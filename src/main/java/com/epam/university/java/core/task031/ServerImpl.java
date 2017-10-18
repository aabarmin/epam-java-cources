package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Random;

public class ServerImpl implements Server {
    protected static final int PORT = 7003;
    private static ServerSocket socket;
    private volatile LinkedList<String> messages = new LinkedList<>();
    private boolean isStopped;

    @Override
    public String readMessage() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (messages.isEmpty()) {
            return "";
        }
        return messages.removeLast();
    }

    @Override
    public void start() {
        try {
            socket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        listen();
    }

    @Override
    public void stop() {
        isStopped = true;
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listen() {
        new Thread(() -> {
            try {
                Socket clientSocket = socket.accept();
                listen();

                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()))) {
                    while (!isStopped) {
                        if (reader.ready()) {
                            messages.addLast(reader.readLine());
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
