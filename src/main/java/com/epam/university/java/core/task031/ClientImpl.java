package com.epam.university.java.core.task031;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation class for Client.
 *
 * @author Sergei Titov
 */
public class ClientImpl implements Client {

    private boolean running = false;
    private static Socket socket = null;
    private Queue<String> messages = new LinkedList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendMessage(String message) {

        messages.add(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        try {
            socket = new Socket(InetAddress.getLocalHost(), Task031Impl.PORT);
            running = true;
            new Thread(() -> {
                try (final BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()))) {
                    while (running) {
                        if (messages.size() > 0) {
                            try {
                                writer.write(messages.poll());
                                writer.newLine();
                                writer.flush();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {

        running = false;

        try {
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
