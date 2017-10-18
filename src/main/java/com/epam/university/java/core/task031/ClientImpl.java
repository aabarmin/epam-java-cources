package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedList;

public class ClientImpl implements Client {
    private Socket socket;
    private LinkedList<String> messages;
    private boolean isStopped = false;

    @Override
    public void sendMessage(String message) {
        messages.addFirst(message);
    }

    @Override
    public void start() {
        messages = new LinkedList<>();
        try {
            socket = new Socket(InetAddress.getLocalHost(), ServerImpl.PORT);
            Thread.sleep(1000);
            new Thread(() -> {
                try (BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()))) {
                    while (!isStopped) {
                        Thread.sleep(1000);
                        if (!messages.isEmpty()) {
                            writer.write(messages.removeLast());
                            writer.newLine();
                            writer.flush();
                        }
                    }
                } catch (IOException | InterruptedException | NullPointerException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

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
}
