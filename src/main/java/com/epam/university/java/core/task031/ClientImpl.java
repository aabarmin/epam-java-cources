package com.epam.university.java.core.task031;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.InetAddress;

import java.net.Socket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ClientImpl implements Client {
    private ExecutorService executor;
    private int port;
    private static Socket clientSocket;
    private BufferedWriter writer;
    private BufferedReader reader;


    public ClientImpl(int port) {
        executor = Executors.newCachedThreadPool();
        this.port = port;
    }

    @Override
    public void sendMessage(String message) {
        try {
            if (writer == null) {
                writer = new BufferedWriter(
                        new OutputStreamWriter(
                                clientSocket.getOutputStream()
                        ));
            }
            writer.write(message + "\n");
            writer.flush();
            System.out.println("message has been send? wait for acknowledgment");
            try {
                if (reader == null) {
                    reader = new BufferedReader(
                            (new InputStreamReader(
                                    (clientSocket.getInputStream()))));
                }
                boolean isDone = false;
                while (!isDone) {
                    if (reader.ready()) {
                        final String s = reader.readLine();
                        System.out.println("acknowledgment received");
                        isDone = true;
                    }
                }
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }

        } catch (Exception ignored) {
            ignored.printStackTrace();

        }

    }

    @Override
    public void start() {
        try {
            clientSocket = new Socket(InetAddress.getLocalHost(), port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Connected to server");
    }

    @Override
    public void stop() {
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Client closed");
    }
}
