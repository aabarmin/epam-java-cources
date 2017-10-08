package com.epam.university.java.core.task031;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

import static com.epam.university.java.core.Callback.runVoid;


public class ServerImpl implements Server {
    private volatile ServerSocket serverSocket;
    private volatile Queue<String> messages;
    private final int port;


    private Thread socketLisenerThread;

    private ServerImpl(int port) {
        this.port = port;
        messages = Collections.asLifoQueue(new ConcurrentLinkedDeque<String>());
    }


    static Server getInstance(int port) {
        return new ServerImpl(port);
    }

    @Override
    public String readMessage() {
        runVoid(() -> {
            Thread.sleep(2000);
            return null;
        });
        System.out.println("readMessage()");
        String messageToReturn = messages.poll();
        String messageToReturnFinal = messageToReturn != null
                ? messageToReturn :
                "";
        System.out.println("returned: " + messageToReturnFinal);
        return messageToReturnFinal;
    }

    @Override
    public void start() {
        runVoid(() -> serverSocket = new ServerSocket(port,
                10, InetAddress.getLocalHost()));
        System.out.println("server created");
        socketLisenerThread = new Thread(new SocketListener(serverSocket, messages));
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
