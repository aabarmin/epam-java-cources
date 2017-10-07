package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ServerImpl implements Server {

    private volatile ServerSocket serverSocket;
    private volatile boolean running = true;
    private Deque<String> messages = new ConcurrentLinkedDeque<>();

    /**
     * Read last received message.
     *
     * @return message text
     */
    @Override
    public String readMessage() {

        String msg = messages.pollLast();
        return (msg == null ? "" : msg);

    }

    /**
     * Start chat server.
     */
    @Override
    public void start() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(6003);
                    while (true) {
                        final Socket acceptedSocket = serverSocket.accept();
                        ClientThread clientThread = new ClientThread(acceptedSocket);
                        clientThread.start();
                    }
                } catch (Exception e) {
                   // e.printStackTrace();
                }

            }
        });

        thread.start();

    }

    /**
     * Stop chat server.
     */
    @Override
    public void stop() {

        running = false;
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private class ClientThread extends Thread {

        private Socket socket = null;

        public ClientThread(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()
                    )
            )) {

                while (running) {
                    if (reader.ready()) {
                        messages.add(reader.readLine());
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
