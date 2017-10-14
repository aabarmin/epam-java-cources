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

    public ClientImpl() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            socket = new Socket(InetAddress.getLocalHost(), 6003);
            System.out.println("Connected to server");
        }catch (Exception e) {
            System.out.println("Exception in constructor" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String message) {
        final Scanner scanner = new Scanner(System.in);
        String userInput;
        userInput = scanner.nextLine();

        try {
            writer.write(userInput + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("void send message" + e.getMessage());
        }
    }

    @Override
    public void start() {

        try{
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
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
