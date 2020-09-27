package com.epam.university.java.core.task031;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Author Dmitry Novikov 10-Sep-20.
 */
public class ClientImpl implements Client {
    private Socket socket;
    private PrintWriter out;

    /**
     * Send message to server.
     *
     * @param message message text
     */
    @Override
    public void sendMessage(String message) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        out.println(message);
    }

    /**
     * Start client.
     */
    @Override
    public void start() {
        try {
            socket = new Socket(InetAddress.getLocalHost(), 5000);
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Stop client.
     */
    @Override
    public void stop() {
        try {
            socket.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}