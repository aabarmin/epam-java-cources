package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerImpl implements Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader reader;

    /**
     * Read last received message.
     *
     * @return message text
     */
    @Override
    public String readMessage() {

        System.out.println("msg reading");

        try {
            if (reader.ready()) {
                return reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";

    }

    /**
     * Start chat server.
     */
    @Override
    public void start() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(6003);
                    clientSocket = serverSocket.accept();
                    reader = new BufferedReader(
                            new InputStreamReader(
                                    clientSocket.getInputStream()
                            )
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }

    /**
     * Stop chat server.
     */
    @Override
    public void stop() {
        try {
            if (clientSocket != null) {
                clientSocket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
