package com.epam.university.java.core.task031;

import java.io.BufferedWriter;
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
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        try {
            Thread.sleep(100);
            serverSocket = new Socket(InetAddress.getLocalHost(), port);
            writer = new BufferedWriter(
                    new OutputStreamWriter(
                            serverSocket.getOutputStream()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        try {
            if (serverSocket != null || !serverSocket.isClosed()) {
                serverSocket.close();
            }
            if (serverSocket != null || !serverSocket.isClosed()) {
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}