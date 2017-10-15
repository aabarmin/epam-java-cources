package com.epam.university.java.core.task031;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * {@inheritDoc}
 */
public class ServerImpl implements Server {
    ServerSocket serverSocket;
    static int count = 0;
    private boolean serverOff = false;
    private BlockingDeque<String> queue = new LinkedBlockingDeque<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public String readMessage() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            final String s = queue.pollFirst(1, TimeUnit.SECONDS);
            if (s != null) {
                return s;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        try {
            serverSocket = new ServerSocket(9000);
            new Thread(() -> {
                try {
                    while (!serverOff) {
                        Socket socket = serverSocket.accept();
                        new ServerThread(socket).start();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {
        serverOff = true;
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class ServerThread extends Thread {

        private BufferedReader br;
        private Socket socket;

        ServerThread(Socket socket) throws IOException {
            this.socket = socket;

        }

        @Override
        public void run() {
            String message;
            try {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while ((message = br.readLine()) != null) {
                    try {
                        queue.putFirst(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        this.interrupt();
                    }
                }
            }
        }
    }
}
