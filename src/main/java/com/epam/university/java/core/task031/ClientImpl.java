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

    /**
     * Send message to server.
     *
     * @param message message text
     */
    @Override
    public void sendMessage(String message) {
        try {
            Thread.sleep(400);
            writer.write(message + "\n");
            writer.flush();
            Thread.sleep(400);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Start client.
     */
    @Override
    public void start() {
        try {
            serverSocket = new Socket(InetAddress.getLocalHost(), port);
            writer = new BufferedWriter(
                    new OutputStreamWriter(
                            serverSocket.getOutputStream()
                    )
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Stop client.
     */
    @Override
    public void stop() {
        try {
            if (writer != null) {
                writer.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
