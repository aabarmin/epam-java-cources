package com.epam.university.java.core.task031;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientImpl implements Client {
    private final int port;
    private Socket serverSocket;
    private BufferedWriter writer;

    ClientImpl(int port) {
        this.port = port;
    }

    @Override
    public void sendMessage(String message) {
        try {
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        try {
            serverSocket = new Socket(InetAddress.getLocalHost(), port);
            writer = new BufferedWriter(
                    new OutputStreamWriter(
                            serverSocket.getOutputStream()
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}