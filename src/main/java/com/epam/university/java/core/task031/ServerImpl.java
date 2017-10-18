package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ilya on 08.10.17.
 */
public class ServerImpl implements Server, Runnable {

    private ServerSocket serverSocket;

    private volatile BlockingDeque<String> massages = new LinkedBlockingDeque<>();

    private Thread serverThread;

    private volatile boolean readed = false;

    private List<Thread> consumers = new ArrayList<>();

    @Override
    public String readMessage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!serverThread.isInterrupted()) {
            while (!readed) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (massages.isEmpty()) {
            return "";
        }
        String mes = massages.pop();
        readed = false;
        System.out.println("read massage");
        return mes;
    }

    @Override
    public void start() {
        try {
            serverSocket = new ServerSocket(6000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        serverThread = new Thread(this);
        serverThread.start();
    }

    @Override
    public void stop() {
        consumers.forEach(Thread::interrupt);
        serverThread.interrupt();
        readed = true;
        try {
            Thread.sleep(2000);
            serverSocket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Socket clientSocket = null;
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            while (!serverThread.isInterrupted()) {
                Thread consumerThread = new Thread(new Consumer(serverSocket.accept()));
                consumers.add(consumerThread);
                consumerThread.start();
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Consumer implements Runnable {

        private final Socket socket;

        public Consumer(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()))) {
                while (!Thread.currentThread().isInterrupted()) {
                    if (reader.ready()) {
                        System.out.println("WE are here");
                        final String fromClient = reader.readLine();
                        System.out.println("WE are here");
                        massages.push(fromClient);
                        System.out.println("Pushed: " + fromClient);
                    }
                    readed = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
