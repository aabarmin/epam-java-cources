package com.epam.university.java.core.task031;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientImpl implements Client {
    private static final int PORT = 7777;
    Socket socket;
    PrintWriter out;

    @Override
    public void sendMessage(String message) {
        if (message == null) {
            throw new IllegalArgumentException();
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        out.println(message);
    }

    @Override
    public void start() {
        try {
            socket = new Socket("localhost", PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
