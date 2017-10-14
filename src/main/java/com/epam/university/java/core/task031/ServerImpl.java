package com.epam.university.java.core.task031;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Вера on 12.10.2017.
 */
public class ServerImpl implements Server {

    ServerSocket serverSocket;
    ArrayList<String> listMessage = new ArrayList<>();
    boolean indicator = false;


    @Override
    public String readMessage() {
        if (listMessage == null) {
            return "";
        } else {
            String result = listMessage.get(0);
            listMessage.remove(0);
            return result;
        }
    }

    @Override
    public void start() {

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Server created");
                    serverSocket = new ServerSocket(6003);
                    while (true) {
                        System.out.println("waiting accept");
                        Socket clientSocket = serverSocket.accept();
                        System.out.println("accepted");
                        MyThread newClient = new MyThread(clientSocket);
                        System.out.println("create new Thread to the Client");
                        newClient.run();
                        System.out.println("add new Client in new Thread");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        thread.run();
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
                while (!(indicator)) {
                    if (reader.ready()) {
                        final String fromClient = reader.readLine();
                        listMessage.add(fromClient);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    @Override
    public void stop() {
        indicator = false;
        try {
            serverSocket.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
