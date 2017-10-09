package com.epam.university.java.core.task031;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Александр on 09.10.2017.
 * Socket and iostreams
 */
public class ServerImpl implements Server {
    private final ServerSocket serverSocket;
    private final Socket clientSocket;

    ServerImpl() {
        try {
            serverSocket = new ServerSocket(6000);
            clientSocket = serverSocket.accept();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Read last received message.
     *
     * @return message text
     */
    @Override
    public String readMessage() {
        return null;
    }

    /**
     * Start chat server.
     */
    @Override
    public void start() {

    }

    /**
     * Stop chat server.
     */
    @Override
    public void stop() {

    }
}
