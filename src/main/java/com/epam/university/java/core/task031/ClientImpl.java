package com.epam.university.java.core.task031;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

import static com.epam.university.java.core.Callback.runVoid;

public class ClientImpl implements Client {
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    private ClientImpl() {
    }

    public static Client getInstance() {
        return new ClientImpl();
    }

    @Override
    public void sendMessage(String message) {
        runVoid(() -> {
            writer.write(message);
            writer.newLine();
            writer.flush();
            System.out.println("mess sended");
            return null;
        });
    }

    @Override
    public void start() {
        runVoid(() -> {
            socket = new Socket(InetAddress.getLocalHost(), 6000);
            System.out.println("client connected");
            reader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            return null;
        });
    }

    @Override
    public void stop() {
        runVoid(() -> {
            reader.close();
            writer.close();
            socket.close();
            return null;
        });
    }
}
