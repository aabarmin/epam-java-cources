package com.epam.university.java.core.task031;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientImpl implements Client {

    private Socket server;
    private PrintWriter writer;

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
            server = new Socket(InetAddress.getLocalHost(),6000);
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
