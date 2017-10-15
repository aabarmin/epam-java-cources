package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Александр on 09.10.2017.
 * Chat server.
 */
public class ServerImpl implements Server {

    private ServerSocket serverSocket;
    private Thread serverThread;
    private Socket clientSocket;
    private int port = 6000;
    BufferedReader reader;

    ServerImpl() {

    }

    /**
     * Read last received message.
     *
     * @return message text
     */
    @Override
    public String readMessage() {
        String message = "";
        try {
            if (reader.ready()) {
                message = reader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("message read (" + message + ")");
        return message;
    }

    /**
     * Start chat server.
     */
    @Override
    public void start() {
        serverThread = new Thread(() -> {
            try {
                serverSocket = new ServerSocket(6000);
                clientSocket = serverSocket.accept();
                reader = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()
                        )
                );
                System.out.println("Server start");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        serverThread.start();
    }

    /**
     * Stop chat server.
     */
    @Override
    public void stop() {
        try {
            reader.close();
            serverThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
