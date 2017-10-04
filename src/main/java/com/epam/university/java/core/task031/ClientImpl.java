package com.epam.university.java.core.task031;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Network chat client.
 */
public class ClientImpl implements Client {

    private final int port;
    private final InetAddress host;
    private DatagramSocket socket;

    /**
     * Creates a new Client instance to connect to LocalHost to specified port.
     * @param port port
     */
    public ClientImpl(int port) {
        try {
            this.host = InetAddress.getLocalHost();
            this.port = port;
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Send message to server.
     * @param message message text
     */
    @Override
    public void sendMessage(String message) {
        final byte[] bytes = message.getBytes();
        final DatagramPacket packet = new DatagramPacket(bytes, bytes.length, host, port);
        try {
            socket.send(packet);
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
            socket = new DatagramSocket();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Stop client.
     */
    @Override
    public void stop() {
        socket.close();
    }

}
