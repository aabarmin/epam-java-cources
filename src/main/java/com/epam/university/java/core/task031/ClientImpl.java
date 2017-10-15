package com.epam.university.java.core.task031;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Вера on 12.10.2017.
 */
public class ClientImpl implements Client {

    private Socket socket;
    private BufferedWriter writer;

    /**
     * This is constructor.
     */
    public ClientImpl() {
        try {
            socket = new Socket(InetAddress.getLocalHost(), 13372);
            System.out.println("Connected to server");
        } catch (Exception e) {
            System.out.println("Exception in constructor" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String message) {
        try {
            writer.write(message + "\n");
            writer.flush();
            System.out.println("message send");
        } catch (IOException e) {
            System.out.println("void send message" + e.getMessage());
        }
    }

    @Override
    public void start() {
        try {
            System.out.println("in start client before writer");
            this.writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("getOutput in client");
        } catch (IOException e) {
            System.out.println("Exception in Client start in writer");
        }

    }

    @Override
    public void stop() {
        try {
            writer.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("void stop" + e.getMessage());
        }
    }
}
