package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Вера on 12.10.2017.
 */
public class ServerImpl implements Server {

    ServerSocket serverSocket;
    Deque<String> listMessage = new LinkedBlockingDeque<>();
    boolean indicator = false;
    ArrayList<Thread> myThreads = new ArrayList<>();

    /**
     * This is constructor.
     */
    public ServerImpl() {
        try {
            this.serverSocket = new ServerSocket(13372);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readMessage() {
        System.out.println("Prepare to read");
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if (listMessage.size() == 0) {
            System.out.println("Read empty");
            return "";
        } else {
            String result = listMessage.pop();
            System.out.println("Read");
            return result;
        }
    }

    @Override
    public void start() {

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        System.out.println("waiting accept");
                        Socket clientSocket = serverSocket.accept();
                        System.out.println("accepted");
                        Thread newClient = new Thread(new MyThread(clientSocket));
                        System.out.println("create new Thread to the Client");
                        myThreads.add(newClient);
                        newClient.start();
                        System.out.println("add new Client in new Thread");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
        myThreads.add(thread);
    }

    private class MyThread implements Runnable {
        Socket clientSocket;

        public MyThread(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            System.out.println("new Client start");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));
                System.out.println("client.getInputStream");
                while (!Thread.currentThread().isInterrupted()) {
                    if (reader.ready()) {
                        System.out.println("before readline");
                        final String fromClient = reader.readLine();
                        System.out.println("after readline");
                        listMessage.push(fromClient);
                        System.out.println("message taken");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    @Override
    public void stop() {
        try {
            myThreads.stream().forEach(s -> s.interrupt());
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
