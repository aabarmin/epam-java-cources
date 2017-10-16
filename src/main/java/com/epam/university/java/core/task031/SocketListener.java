package com.epam.university.java.core.task031;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static com.epam.university.java.core.Callback.runObject;
import static com.epam.university.java.core.Callback.runVoid;

class SocketListener implements Runnable {
    private ServerSocket serverSocket;
    private List<Thread> list;
    private volatile Queue<String> messages;

    SocketListener(ServerSocket serverSocket, Queue<String> messages) {
        this.messages = messages;
        this.serverSocket = serverSocket;
        list = new ArrayList<>();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Socket clientSocket = runObject(() -> serverSocket.accept());
            if (clientSocket != null) {
                list.add(
                        new Thread(() -> runVoid(() -> {
                            while (!Thread.currentThread().isInterrupted()) {
                                BufferedReader reader =
                                        new BufferedReader(new InputStreamReader(
                                                clientSocket.getInputStream()));
                                while (!Thread.currentThread().isInterrupted()) {
                                    String readed = runObject(() -> {
                                        String fromClient = null;
                                        if (reader.ready()) {
                                            fromClient = reader.readLine();
                                        }
                                        return fromClient;
                                    });
                                    synchronized (messages) {
                                        if (readed != null) {
                                            messages.add(readed);
                                        }
                                        messages.notify();
                                    }
                                }
                                reader.close();
                            }
                            return null;
                        })));
                list.get(list.size() - 1).start();
            }

        }
        runVoid(() -> {
            serverSocket.close();
            return null;
        });
        list.forEach(Thread::interrupt);
    }
}