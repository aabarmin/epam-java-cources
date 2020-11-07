package com.epam.university.java.core.task031;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientImpl implements Client {

    private Socket socket;
    private BufferedWriter out;

    @Override
    public void sendMessage(String message) {
        if (message == null) {
            throw new IllegalArgumentException();
        }
        try {
            out.write(message + "\n");
            out.flush();
            Thread.sleep(100);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        try {
            Thread.sleep(100);
            socket = new Socket(InetAddress.getLocalHost(), 9090);
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        try {
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
