package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

public class ServerImpl implements Server {
    private ServerSocket serverSocket;
    private ArrayList<Socket> clients;
    private LinkedList<String> messages;
    private BufferedReader reader;

    public ServerImpl(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clients = new ArrayList<>();
            messages = new LinkedList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readMessage() {
        getMessage();
        if (!messages.isEmpty()) {
            return messages.removeLast();
        }
        return "";
    }

    @Override
    public void start() {
        new Thread(() -> {
            while (!serverSocket.isClosed()) {
                try {
                    Socket accept = serverSocket.accept();
                    clients.add(accept);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    @Override
    public void stop() {
        try {
            if (reader != null) {
                reader.close();
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getMessage() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Socket socket : clients) {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (reader.ready()) {
                    String s = reader.readLine();
                    messages.add(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
