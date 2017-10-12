package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;



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

    /*    synchronized (Task031Impl.monitor)*/ {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (messages.isEmpty()) {
    System.out.println("Server reads: ''.   this == " + this.hashCode() );
                return "";
            }

            String result = messages.pollLast();

            System.out.println("Server reads: " + result + ". Size == " + messages.size() + ".   this == " + this.hashCode());

            return result;
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {


        createListeningThread();
        // create socket
     /*   synchronized (this) */

        System.out.println("Exiting start()-method");

    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {

        System.out.println("Server: STOPPED");
/*
        for (Map.Entry<Object, Boolean> entry : clients.entrySet()) {
            entry.setValue(false);
        }*/
    }


    // createListeningThread
    private void createListeningThread() {

        // accept
        new Thread(() -> {
            try {
                // accept
                Socket clientSocket = socket.accept();
System.out.println("Server: Connection established");
                createListeningThread();

                try (
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(
                                        clientSocket.getInputStream())
                        )
                ) {
                    clients.put(clientSocket, true);
                    while (clients.get(clientSocket)) {
                        if (reader.ready()) { // refactor - move one line up
                            /*synchronized (Task031Impl.monitor)*/ {
                                final String string = reader.readLine();
                                messages.add(string);
                                System.out.println("Server got message: " + string + ". Size == " + messages.size() + ".   this == " + this.hashCode());
                            }
                        }
                    }

System.out.println("clientSocket's Thread exiting!");

                    //clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
