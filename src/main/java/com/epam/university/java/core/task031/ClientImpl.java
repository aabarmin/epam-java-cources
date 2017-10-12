package com.epam.university.java.core.task031;

import com.sun.xml.internal.ws.transport.http.HttpAdapter;

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
        System.out.println("Client: added \'" + message + "\' to queue");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        try {
            socket = new Socket(InetAddress.getLocalHost(), Task031Impl.PORT);
            System.out.println("Client: Connected to server");
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
                                System.out.println("Client: flushed");
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
        messages.clear();

        try {
            //Thread.sleep(500);
            //socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Client: STOPPED");
    }
}
