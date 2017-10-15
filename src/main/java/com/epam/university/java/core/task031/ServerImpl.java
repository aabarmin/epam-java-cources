package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayDeque;
import java.util.Deque;

public class ServerImpl implements Server {
    private volatile ServerSocket serverSocket;
    private volatile Deque<String> queue = new ArrayDeque<>();
    private volatile boolean isWorking = true;
    private final int port;

    ServerImpl(int port) {
        this.port = port;
    }

    @Override
    public  String readMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return queue.isEmpty() ? "" : queue.removeLast();
    }

    @Override
    public void start() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(500);
                serverSocket = new ServerSocket(port);
                while (isWorking) {
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
                            throw new RuntimeException(e);
                        }
                    }).start();
                    Thread.sleep(500);
                }
            } catch (SocketException e) {
                stop();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
    }

    @Override
    public void stop() {
        isWorking = false;
        try {
            Thread.sleep(500);
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
            Thread.sleep(500);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}