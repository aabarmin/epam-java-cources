package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ServerImpl implements Server {
    private volatile ServerSocket serverSocket;
    private volatile Deque<String> queue = new ConcurrentLinkedDeque<>();
    private boolean inProcess;

    @Override
    public synchronized String readMessage() {
        if (queue.isEmpty()) {
            try {
                wait(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.isEmpty() ? "" : queue.pollLast();
    }

    @Override
    public void start() {
        inProcess = true;
        Thread thread = new Thread(() -> {
            try {
                serverSocket = new ServerSocket(6000);
                while (inProcess && !serverSocket.isClosed()) {
                    final Socket acceptedSocket = serverSocket.accept();
                    new Thread(() -> {
                        try (final BufferedReader reader = new BufferedReader(
                                new InputStreamReader(acceptedSocket.getInputStream()))) {
                            while (inProcess) {
                                if (reader.ready()) {
                                    queue.addLast(reader.readLine());
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            } catch (Exception e) {
                System.out.println();
            }
        });
        thread.start();
    }

    @Override
    public void stop() {
        inProcess = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}