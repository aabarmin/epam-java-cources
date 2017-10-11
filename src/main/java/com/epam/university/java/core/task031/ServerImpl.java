package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ilya on 08.10.17.
 */
public class ServerImpl implements Server, Runnable {

    private final ServerSocket serverSocket = new ServerSocket(6000);
    private String monitor = "monitor";
    private Deque<String> massages = new ArrayDeque<>();
    private boolean isWork;

    public ServerImpl() throws IOException {

    }

    @Override
    public String readMessage() {
        synchronized (monitor) {
            if (massages.isEmpty()) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("read massage");
        if (massages.isEmpty()) {
            return "";
        }
        return massages.pop();
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
        while (isWork == true) {
            try (Socket clientSocket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()))) {
                if (reader.ready()) {
                    System.out.println("WE are here");
                    final String fromClient = reader.readLine();
                    System.out.println("WE are here");
                    massages.push(fromClient);
                    System.out.println("Pushed: " + fromClient);
                    monitor.notify();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
