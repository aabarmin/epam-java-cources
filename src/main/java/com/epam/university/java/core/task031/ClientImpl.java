package com.epam.university.java.core.task031;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by ilya on 08.10.17.
 */
public class ClientImpl implements Client, Runnable {

    private Socket socket;

    private String massage;

    private Thread clientThread;

    private boolean sended = false;

    /**
     * Constructor.
     */
    public ClientImpl() {
        try {
            socket = new Socket(InetAddress.getLocalHost(), 6000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String message) {
        if (massage != null) {
            while (sended == false) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        sended = false;
        this.massage = message;
    }

    @Override
    public void start() {
        clientThread = new Thread(this);
        clientThread.start();
    }

    @Override
    public void stop() {
        clientThread.interrupt();
        try {
            Thread.sleep(2000);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try (final BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(socket.getOutputStream()))) {
            while (!clientThread.isInterrupted()) {
                if (massage != null) {
                    writer.write(massage + "\n");
                    writer.flush();
                    System.out.println("Sended: " + massage);
                    massage = null;
                    sended = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
