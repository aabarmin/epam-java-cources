package com.epam.university.java.core.task031;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

import static com.epam.university.java.core.Callback.runObject;
import static com.epam.university.java.core.Callback.runVoid;


public class ServerImpl implements Server {
    private volatile ServerSocket serverSocket;
    private volatile Queue<String> messages;
    private Socket clientSocket;
    private Thread socketLisenerThread;

    private ServerImpl() {
        messages = Collections.asLifoQueue(new ConcurrentLinkedDeque<String>());
    }


    static Server getIstance() {
        return new ServerImpl();
    }

    @Override
    public String readMessage() {
        runVoid(() -> {
            Thread.sleep(1000);
            return null;
        });
//        synchronized (lastMessage) {
//            runVoid(() -> {
//                lastMessage.wait();
//                return null;
//            });
//        }
        System.out.println("readMessage()");
        String messageToReturn = messages.poll();
        return messageToReturn != null
                ? messageToReturn :
                "";
    }

    @Override
    public void start() {
        runVoid(() -> serverSocket = new ServerSocket(6000, 10, InetAddress.getLocalHost()));
        System.out.println("server created");
        socketLisenerThread = new Thread(new socketLisener(serverSocket, messages));
        socketLisenerThread.start();
    }

    @Override
    public void stop() {
        runVoid(() -> {
            socketLisenerThread.interrupt();
            return null;
        });
    }
}

class socketLisener implements Runnable {
    private ServerSocket serverSocket;
    private List<Thread> list;
    private volatile Queue<String> messages;

    socketLisener(ServerSocket serverSocket, Queue<String> messages) {
        this.messages = messages;
        this.serverSocket = serverSocket;
        list = new ArrayList<>();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Socket clientSocket = runObject(() -> serverSocket.accept());
            if (clientSocket != null) {
                System.out.println("clientSocket created");
                list.add(
                        new Thread(() -> runVoid(() -> {
                            while (!Thread.currentThread().isInterrupted()) {
                                BufferedReader reader = new BufferedReader(new InputStreamReader(
                                        clientSocket.getInputStream()));
                                System.out.println("Reader/Writer created");
                                while (!Thread.currentThread().isInterrupted()) {
                                    String readed = runObject(() -> {
                                        String fromClient = null;
                                        if (reader.ready()) {
                                            fromClient = reader.readLine();
                                            System.out.println("fromClient: " + fromClient);
                                        }
                                        return fromClient;
                                    });
                                    synchronized (messages) {
                                        if (readed != null) {
                                            messages.add(readed);
                                        }
                                        messages.notify();
                                    }
                                }
                                reader.close();
                            }
                            return null;
                        })));
            }
        }
        runVoid(() -> {
            serverSocket.close();
            return null;
        });
        list.forEach(Thread::interrupt);
    }
}