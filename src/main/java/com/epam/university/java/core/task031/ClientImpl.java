package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Александр on 09.10.2017.
 * Network chat client.
 */
public class ClientImpl implements Client {
    private Socket socket;
    Thread clientThread;
    BufferedWriter writer;

    ClientImpl() {
    }

    /**
     * Send message to server.
     *
     * @param message message text
     */
    @Override
    public void sendMessage(String message) {
        try {
            writer.write(message);
            //writer.flush();
            System.out.println("message send (" + message + ")");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Start client.
     */
    @Override
    public void start() {
        try {
            socket = new Socket(InetAddress.getLocalHost(), 6000);
            writer = new BufferedWriter(
                    new OutputStreamWriter(
                            socket.getOutputStream()
                    )
            );
            System.out.println("Client start");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Stop client.
     */
    @Override
    public void stop() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
