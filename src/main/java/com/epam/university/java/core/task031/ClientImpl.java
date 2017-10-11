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

    private final Socket socket = new Socket(InetAddress.getLocalHost(), 6000);
    private boolean isWork;
    private String massage;

    public ClientImpl() throws IOException {
    }

    @Override
    public void sendMessage(String message) {
        this.massage = message;
    }

    @Override
    public void start() {
        isWork = true;
        new Thread(this).start();
    }

    @Override
    public void stop() {
        isWork = false;
    }

    @Override
    public void run() {
        try (final BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(socket.getOutputStream()))) {
            while (isWork == true) {
                if (massage != null) {
                    writer.write(massage);
                    writer.flush();
                    System.out.println("Sended: " + massage);
                    massage = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
