package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientImpl implements Client {

    private final Socket socket;
    private final BufferedWriter writer;

    public ClientImpl(String ip, int port) throws IOException {
        this.socket = new Socket(ip, port);
        this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    @Override
    public void sendMessage(String message) {
        try {
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void start() {
        new Thread(() ->{

        });

    }

    @Override
    public void stop() {
        try {
            socket.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
