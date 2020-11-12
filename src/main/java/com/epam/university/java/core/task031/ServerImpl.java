package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements Server {
    ServerSocket serverSocket = null;
    private boolean isRunning;
    private List<String> messages = new ArrayList<>();

    @Override
    public String readMessage() {

        String entry;
        if (messages.isEmpty()) {
            entry = "";
        } else {
            entry = messages.remove(messages.size() - 1);
        }


        return entry;
    }

    @Override
    public void start() {
        isRunning = true;
        try {
            serverSocket = new ServerSocket(9090);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            while (true) {
                try {
                    Socket client = serverSocket.accept();
                    new Thread(() -> {
                        try (BufferedReader reader = new BufferedReader(
                                new InputStreamReader(client.getInputStream()))) {
                            while (isRunning) {
                                if (reader.ready()) {
                                    messages.add(reader.readLine());
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    @Override
    public void stop() {
        isRunning = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
