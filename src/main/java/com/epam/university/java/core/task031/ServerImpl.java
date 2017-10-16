package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;

public class ServerImpl implements Server {
    private volatile boolean isWorking = true;
    private volatile ServerSocket serverSocket;
    private volatile Deque<String> queue = new ArrayDeque<>();

    public  String readMessage() {
        return queue.isEmpty() ? "" : queue.removeLast();
    }

    @Override
    public void start() {
        Thread thread = new Thread(() -> {
            try {
                serverSocket = new ServerSocket(6000);
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    new Thread(() -> {
                        try (BufferedReader reader
                                     = new BufferedReader(new InputStreamReader(clientSocket
                                .getInputStream()))) {
                            while (isWorking) {
                                if (reader.ready()) {
                                    queue.add(reader.readLine());
                                }
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            } catch (Exception e) {
                throw new RuntimeException();
            }
        });
        thread.start();
    }

    @Override
    public void stop() {
        isWorking = false;
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}