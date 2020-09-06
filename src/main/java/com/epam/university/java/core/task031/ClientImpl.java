package com.epam.university.java.core.task031;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientImpl implements Client {
    private final int port;
    private Socket server;
    private PrintWriter writer;

    public ClientImpl(int port) {
        this.port = port;
    }

    @Override
    public void sendMessage(String message) {
        try {
            writer = new PrintWriter(server.getOutputStream(),true);
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void start() {
        try {
            server = new Socket(InetAddress.getLocalHost(),port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        try {
            if (writer != null) {
                writer.close();
            }
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
