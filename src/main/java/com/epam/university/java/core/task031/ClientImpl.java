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
            writer.write(message +  System.lineSeparator());
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Start client.
     */
    @Override
    public void start() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            socket = new Socket(InetAddress.getLocalHost(), 6003);
            writer = new BufferedWriter(
                    new OutputStreamWriter(
                            socket.getOutputStream()
                    ));
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
            if (writer != null) {
                writer.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
