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

    ClientImpl() {
        new Runnable() {
            @Override
            public void run() {

                try {
                    socket = new Socket(InetAddress.getLocalHost(), 6000);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }.run();
    }

    /**
     * Send message to server.
     *
     * @param message message text
     */
    @Override
    public void sendMessage(String message) {
        try (
                final BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()
                        )
                );

        ) {
            writer.write(message + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Start client.
     */
    @Override
    public void start() {

    }

    /**
     * Stop client.
     */
    @Override
    public void stop() {

    }
}
