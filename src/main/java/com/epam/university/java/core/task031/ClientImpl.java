package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientImpl implements Client {
    private Socket client = null;
    private PrintWriter out = null;

    @Override
    public void sendMessage(String message) {
        out.println(message);
        try {
            Thread.sleep(183);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        try {
            client = new Socket("localhost",5000);
            out = new PrintWriter(client.getOutputStream(),true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
