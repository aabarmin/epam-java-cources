package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Romin Nuro on 11.09.2020 15:28.
 */
public class ServerImpl implements Server {
    private final Deque<String> messages = new LinkedList<>();
    private ServerSocket serverSocket;
    private List<Thread> threads = new LinkedList<>();
    private boolean isWorking;

    /**
     * Read last received message.
     *
     * @return message text
     */
    @Override
    public String readMessage() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (messages.size() == 0) {
            return "";
        }
        return messages.poll();
    }

    /**
     * Start chat server.
     */
    @Override
    public void start() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(Task031Impl.PORT);
                isWorking = true;
                while (!serverSocket.isClosed()) {
                    Socket client = serverSocket.accept();
                    new Thread(() -> {
                        try (BufferedReader reader = new BufferedReader(
                                new InputStreamReader(client.getInputStream()))) {
                            while (isWorking) {
                                if (reader.ready()) {
                                    messages.push(reader.readLine());
                                    System.out.println("Message received: " + messages.peek());
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * Stop chat server.
     */
    @Override
    public void stop() {
        isWorking = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
