package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


/**
 * Implementation class for Server.
 *
 * @author Sergei Titov
 */
public class ServerImpl implements Server {

    private static ServerSocket socket;

    static {
        try {
            socket = new ServerSocket(Task031Impl.PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Deque<String> messages = new LinkedList<>();
    private Map<Object, Boolean> clients = new HashMap<>();


    /**
     * {@inheritDoc}
     */
    @Override
    public String readMessage() {

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (messages.isEmpty()) {
            return "";
        }

        return messages.pollLast();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {

        createListeningThread();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {

        for (Map.Entry<Object, Boolean> entry : clients.entrySet()) {
            entry.setValue(false);
        }
    }


    // createListeningThread
    private void createListeningThread() {

        new Thread(() -> {
            try {
                // accept
                Socket clientSocket = socket.accept();
                createListeningThread();

                try (
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(
                                        clientSocket.getInputStream())
                        )
                ) {
                    clients.put(clientSocket, true);
                    while (clients.get(clientSocket)) {
                        if (reader.ready()) {
                            messages.add(reader.readLine());
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
