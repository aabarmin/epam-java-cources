package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Deque;
import java.util.LinkedList;


public class ServerImpl implements Server {
    private final int port;
    private volatile boolean isWorking = true;
    private volatile ServerSocket serverSocket;
    private volatile Deque<String> queue = new LinkedList<>();

    ServerImpl(int port) {
        this.port = port;
    }

    /**
     * Read last received message.
     *
     * @return message text
     */
    public String readMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return !queue.isEmpty() ? queue.pollLast() : "";
    }

    /**
     * Start chat server.
     */
    @Override
    public void start() {
        Thread listenerThread = new Thread(() -> {
            try {
                Thread.sleep(500);
                serverSocket = new ServerSocket(port);
                while (isWorking) {
                    Socket clientSocket = serverSocket.accept();
                    Thread readerThread = new Thread(() -> {
                        try (
                                BufferedReader reader = new BufferedReader(
                                        new InputStreamReader(
                                                clientSocket.getInputStream()
                                        )
                                )
                        ) {

                            while (isWorking) {
                                if (reader.ready()) {
                                    queue.add(reader.readLine());
                                }
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                    readerThread.setPriority(Thread.MAX_PRIORITY);
                    readerThread.start();
                    Thread.sleep(500);
                }
            } catch (SocketException e) {
                stop();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        listenerThread.setPriority(Thread.MAX_PRIORITY);
        listenerThread.start();
    }

    /**
     * Stop chat server.
     */
    @Override
    public void stop() {
        isWorking = false;
        try {
            Thread.sleep(500);
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
            Thread.sleep(500);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
