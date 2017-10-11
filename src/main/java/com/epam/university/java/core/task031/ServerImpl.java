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
    private boolean wereRecords = false;

    ServerImpl(int port) {
        this.port = port;
    }

    /**
     * Read last received message.
     *
     * @return message text
     */
    public String readMessage() {
        // trying to wait, if there was no records on queue
        for (int i = 0; i < 100; i++) {
            if (queue.size() == 0 && !wereRecords) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }

        return queue.size() > 0 ? queue.removeLast() : "";
    }

    /**
     * Start chat server.
     */
    @Override
    public void start() {
        Thread listenerThread = new Thread(() -> {
            try {
                serverSocket = new ServerSocket(port);
                while (true) {
                    if (serverSocket != null && !serverSocket.isClosed()) {
                        Socket clientSocket = serverSocket.accept();
                        Thread readerThread = new Thread(() -> {
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
                                        wereRecords = true;
                                    }
                                }
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });
                        readerThread.setPriority(Thread.MAX_PRIORITY);
                        readerThread.start();
                    }
                }
            } catch (SocketException e) {
                System.out.println("Do nothing");
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
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
