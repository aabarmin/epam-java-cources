package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ServerImpl implements Server {

    private ConcurrentLinkedDeque<String> messages;
    private Thread serverThread;
    private ExecutorService executor;
    private ServerSocket serverSocket;
    private boolean isClosed = false;

    /**
     * constructor of server with given port.
     * @param port port for server socket
     */
    public ServerImpl(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        executor = Executors.newCachedThreadPool();
        messages = new ConcurrentLinkedDeque<>();


    }

    @Override
    public String readMessage() {
        if (messages.isEmpty()) {
            return "";
        } else {
            return messages.pollLast();
        }


    }

    @Override
    public void start() {
        serverThread = new Thread(this::serverMainFunction);
        serverThread.start();
    }


    @Override
    public void stop() {
        isClosed = true;
        System.out.println("trying to STOP server");
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Main function for server thread.
     */
    private void serverMainFunction() {

        while (!isClosed) {
            try {
                System.out.println("waiting for client");
                final Socket clientSocket = serverSocket.accept();
                executor.execute(() -> {
                    clientProcessingFunction(clientSocket);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        while (!executor.isTerminated()) {
            try {
                executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * Function for clien processing thread.
     * @param clientSocket socket of client
     */
    private void clientProcessingFunction(Socket clientSocket) {

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()
                )
        );
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(
                             clientSocket.getOutputStream()
                     )
             )
        ) {
            System.out.println("client is closed: " + clientSocket.isClosed());
            while (!clientSocket.isClosed()) {
                if (reader.ready()) {
                    final String fromClient = reader.readLine();
                    System.out.println("trying to process message: " + fromClient);
                    System.out.println("message received: " + fromClient);
                    messages.addLast(fromClient);
                    //writer.write("From server: "+ fromClient + "\n");
                    //writer.flush();
                    writer.write("message received" + "\n");
                    writer.flush();
                }
            }
            System.out.println("client is closed: " + clientSocket.isClosed());

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
