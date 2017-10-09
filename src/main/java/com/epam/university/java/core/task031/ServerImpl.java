package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;

public class ServerImpl implements Server {
    private volatile ServerSocket serverSocket;
    private volatile Deque<String> queue = new ArrayDeque<>();
    private volatile Object monitor = new Object();
    private volatile boolean isWorking;

    ServerImpl(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readMessage() {
        synchronized (monitor) {
            if (queue.isEmpty()) {
                try {
                    monitor.wait(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return queue.isEmpty() ? "" : queue.removeLast();
    }

    @Override
    public void start() {
        isWorking = true;
        Thread thread = new Thread(() -> {
            try {
                while (isWorking) {
                    if (serverSocket != null && !serverSocket.isClosed()) {
                        Socket clientSocket = serverSocket.accept();
                        new Thread(() -> {
                            try (final BufferedReader reader = new BufferedReader(
                                    new InputStreamReader(clientSocket.getInputStream()))) {
                                while (isWorking) {
                                    if (reader.ready()) {
                                        queue.addLast(reader.readLine());
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }).start();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    @Override
    public void stop() {
        isWorking = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
