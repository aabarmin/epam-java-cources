package com.epam.university.java.core.task031;


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * {@inheritDoc}
 */
public class ClientImpl implements Client {
    private Socket socket;
    private OutputStream outputStream;
    PrintWriter printWriter;

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void sendMessage(String message) {

        printWriter.println(message);
        printWriter.flush();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        try {
            socket = new Socket("localhost", 9000);
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {
        if (printWriter != null) {
            printWriter.close();
        }
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
