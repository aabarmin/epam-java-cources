package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;


public class ServerImpl implements Server {
    private final int port;
    private volatile ServerSocket serverSocket;
    private volatile LinkedList<String> queue = new LinkedList<>();

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
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return queue.size() > 0 ? queue.removeLast() : "";
    }

    /**
     * Start chat server.
     */
    @Override
    public void start() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(port);
                while (true) {
                    if (serverSocket != null && !serverSocket.isClosed()) {
                        Socket clientSocket = serverSocket.accept();

                        new Thread(() -> {
                            try (
                                    final BufferedReader reader = new BufferedReader(
                                            new InputStreamReader(
                                                    clientSocket.getInputStream()
                                            )
                                    )
                            ) {

                                while (true) {
                                    if (reader.ready()) {
                                        queue.addLast(reader.readLine());
                                    }
                                }
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }).start();
                    }
                }
            } catch (SocketException e) {
                System.out.println("Do nothing");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    /**
     * Stop chat server.
     */
    @Override
    public void stop() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
