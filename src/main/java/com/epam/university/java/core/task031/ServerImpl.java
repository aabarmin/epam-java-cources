package com.epam.university.java.core.task031;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Chat server.
 */
public class ServerImpl implements Server {

    private static final int packetSize = 512;
    private final int port;
    private DatagramSocket socket;
    private final Deque<String> messageDeque;

    /**
     * Creates a new Server instance to connect to specified port.
     * @param port port
     */
    public ServerImpl(int port) {
        this.port = port;
        messageDeque = new LinkedList<>();
    }

    /**
     * Read last received message.
     * @return message text
     */
    @Override
    public String readMessage() {
        try {
            while (true) {
                socket.setSoTimeout(10); // 0.01 sec timeout. throws exception if didn't get message
                final byte[] buffer = new byte[packetSize];
                final DatagramPacket packet = new DatagramPacket(buffer, packetSize);
                socket.receive(packet);
                messageDeque.addFirst(new String(packet.getData(), 0, packet.getLength()));
            }
        } catch (Exception ignored) { // no more messages
            return messageDeque.isEmpty()
                ? ""
                : messageDeque.removeFirst(); // take the most recent message
        }
    }

    /**
     * Start chat server.
     */
    @Override
    public void start() {
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Stop chat server.
     */
    @Override
    public void stop() {
        socket.close();
    }

}
