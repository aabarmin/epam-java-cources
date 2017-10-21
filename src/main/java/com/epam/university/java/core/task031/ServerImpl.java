package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.*;

public class ServerImpl implements Server {
    private ServerSocket server = null;
    private Socket client = null;
    private final ConcurrentLinkedDeque<String> messages = new ConcurrentLinkedDeque<>();
    private ExecutorService executorService = Executors.newFixedThreadPool(2,Executors.privilegedThreadFactory());
    private boolean listening = true;
    @Override
    public String readMessage() {

        if (!messages.isEmpty()) {
            return messages.pollLast();
        } else {
            return "";
        }
    }

    @Override
    public void start() {

        try {
            server = new ServerSocket(5000);
            new Thread(() -> {
                try {
                    if (!listening) {
                        server.close();
                    }
                    while (listening) {
                        client = server.accept();
                        executorService.submit(new ServerThread(client));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        try {
            executorService.shutdown();
            executorService.awaitTermination(100,TimeUnit.MILLISECONDS);
            if(executorService.isShutdown()) {
                server.close();
                System.out.println("server closed");
            }
            listening = false;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private class ServerThread implements Runnable {
        private Socket client;
        private BufferedReader in;
        private String text;

        ServerThread(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                while ((text = in.readLine()) != null) {
                    messages.add(text);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}