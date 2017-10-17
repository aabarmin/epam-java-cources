package com.epam.university.java.core.task031;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by ilya on 08.10.17.
 */
public class ClientImpl implements Client {

    private Socket socket;

    private BufferedWriter writer;

    @Override
    public void sendMessage(String message) {
        try {
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Sended: " + message);
    }

    @Override
    public void start() {
        try {
            socket = new Socket(InetAddress.getLocalHost(), 6000);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        try {
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
