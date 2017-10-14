package com.epam.university.java.core.task031;

import com.epam.university.java.core.utils.common.Logger;
import com.epam.university.java.core.utils.common.Validator;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class implements <code>Server</code> class.
 */
public class ServerImpl implements Server {
    private List<String> chat = new ArrayList<>();
    private AtomicInteger messagesCounter = new AtomicInteger();
    private List<PrintWriter> readyClientOutputStreams;
    private ExecutorService executorService;
    private ServerSocket serverSocket;
    private Logger logger = new Logger();

    /**
     * Initialization of the class instance.
     *
     * @throws IOException @see IOException(String message)
     */
    ServerImpl() {
        try {
            serverSocket = new ServerSocket(0);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Update client's chat's with the new message.
     *
     * @param textLine message to add
     */
    private void updateClientsChat(String textLine) {
        for (PrintWriter printWriter : readyClientOutputStreams) {
            printWriter.println(textLine);
            printWriter.flush();
        }
    }

    /**
     * Get the port that is assigned by the system to the server's socket.
     *
     * @return <code>int</code> the server's socket
     */
    int getPort() {
        return serverSocket.getLocalPort();
    }

    @Override
    public String readMessage() {
        if (messagesCounter.get() < chat.size()) {
            messagesCounter.incrementAndGet();
            return chat.get(chat.size() - 1
                    - (messagesCounter.get() - 1));
        }
        return "";
    }

    @Override
    public void start() {
        readyClientOutputStreams = new ArrayList<>();
        new Thread(() -> {
            try {
                logger.addLoggerLine(this.getClass().getName()
                                + ": server is waiting for connections...",
                        false);
                executorService = Executors.newFixedThreadPool(1000);
                for (;;) {
                    Socket clientSocket = serverSocket.accept();
                    PrintWriter printWriter = new PrintWriter(clientSocket
                            .getOutputStream());
                    readyClientOutputStreams.add(printWriter);
                    executorService.execute(new ClientHandler(clientSocket));
                }
            } catch (IOException ex) {
                //ex.printStackTrace();
            }
        }).start();
    }

    @Override
    public void stop() {
        executorService.shutdownNow();
        try {
            serverSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        logger.addLoggerLine(this.getClass().getName()
                        + ": server's socket is closed...",
                false);
    }

    /**
     * Class implements reading from the client's stream.
     **/
    class ClientHandler implements Runnable {
        private Socket clientSocket;

        private ClientHandler(Socket clientSocket) {
            Validator.validateNotNull(clientSocket, Validator
                    .MESSAGE_FOR_SOURCE_IF_NULL);
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            String textLine;
            try {
                BufferedReader bufferedReader = new BufferedReader(new
                        InputStreamReader(clientSocket.getInputStream()));
                while ((textLine = bufferedReader.readLine()) != null) {
                    updateClientsChat(textLine);
                    chat.add(textLine);
                    logger.addLoggerLine(this.getClass().getName()
                                    + ": have got the message from the "
                                    + "client..." + textLine,
                            false);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}