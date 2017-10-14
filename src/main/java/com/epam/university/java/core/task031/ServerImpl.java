package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Александр on 09.10.2017.
 * Chat server.
 */
public class ServerImpl implements Server {

    private ServerSocket serverSocket;
    private Thread serverThread;
    private Socket clientSocket;
    private int port = 6000;
    BlockingQueue<SocketProcessor> socketProcessorQueue = new LinkedBlockingQueue<SocketProcessor>();


    ServerImpl() {
        try {
            serverSocket = new ServerSocket(6000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Read last received message.
     *
     * @return message text
     */
    @Override
    public String readMessage() {
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()
                        )
                );
        ) {
            if (reader.ready()) {
                return reader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    /**
     * Start chat server.
     */
    @Override
    public void start() {
        /*try {
            serverSocket = new ServerSocket(6000);
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        serverThread = Thread.currentThread();
        while (true) {
            Socket newClientSocket = createNewClient();

            if (serverThread.isInterrupted()) {
                break;
            } else if (newClientSocket != null) {
                try {
                    final SocketProcessor processor = new SocketProcessor(newClientSocket);
                    final Thread thread = new Thread(processor);
                    thread.setDaemon(true);
                    thread.start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }*/
    }

    private Socket createNewClient() {
         return null;
    }

    /**
     * Stop chat server.
     */
    @Override
    public void stop() {

    }

    /**
     * Class for work with multiply clients.
     */
    private class SocketProcessor implements Runnable {
        Socket socket;
        BufferedReader reader;
        BufferedWriter writer;

        /**
         * Save socket, try to crate reader.
         * @param socketParam socket
         * @throws RuntimeException if cant create BufferedReader
         */
        SocketProcessor(Socket socketParam){
            try {
                socket = socketParam;
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {

        }
    }
}
