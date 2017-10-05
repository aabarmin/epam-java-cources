package com.epam.university.java.core.task031;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientImpl implements Client {

    private Socket socket;
    private BufferedWriter writer;

    /**
     * Send message to server.
     *
     * @param message message text
     */
    @Override
    public void sendMessage(String message) {

        try {
            writer.write(message);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Start client.
     */
    @Override
    public void start() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            socket = new Socket(InetAddress.getLocalHost(), 6003);
            writer = new BufferedWriter(
                    new OutputStreamWriter(
                            socket.getOutputStream()
                    ));
            System.out.println("Connected to server");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Stop client.
     */
    @Override
    public void stop() {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
