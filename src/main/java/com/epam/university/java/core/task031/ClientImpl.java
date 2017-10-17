package com.epam.university.java.core.task031;

import com.epam.university.java.core.utils.common.Logger;
import com.epam.university.java.core.utils.common.ThreadUtility;
import com.epam.university.java.core.utils.common.Validator;

import java.net.Socket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Class implements <code>Client</code> interface.
 */
public class ClientImpl implements Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private List<String> chat = new ArrayList<>();
    private String ipV4Address = "127.0.0.1";
    private int port;
    private boolean isStopped = false;
    private Logger logger = new Logger();

    /**
     * Initialisation of the class.
     *
     * @param port the port
     * @throws IllegalArgumentException if the port is illegal
     */
    ClientImpl(int port) {
        Validator.validateValueRange(port, 1024, 65535,
                Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        this.port = port;
    }

    /**
     * Update client's chat.
     *
     * @throws IOException @see IOException#IOException(String message)
     */
    private void chatUpdating() {
        Thread threadReading = new Thread(() -> {
            String textLine;
            try {
                while ((textLine = bufferedReader.readLine()) != null
                        && !isStopped) {
                    chat.add(textLine);
                    logger.addLoggerLine(this.getClass().getName()
                            + ": updated the chat from the server..."
                            + textLine, false);
                }
            } catch (IOException ex) {
                // ex.printStackTrace();
            }
        });
        threadReading.start();
    }

    /**
     * Set up networking.
     *
     * @param ipV4Address server's IPv4 address
     * @param port        server's port
     * @throws IllegalArgumentException if <code>ipV4Address</code> of
     *                                  <code>port</code> is illegal
     */
    private void setUpNetworking(String ipV4Address, int port) {
        Validator.validateInetAddress(ipV4Address,
                Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER,
                Validator.MESSAGE_IF_ILLEGAL_IPV4_ADDRESS);
        Validator.validateValueRange(port, 1024, 65356,
                Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        try {
            socket = new Socket(ipV4Address, port);
            bufferedReader = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());
            logger.addLoggerLine(this.getClass().getName()
                    + ": networking established...", false);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String message) {
        Validator.validateNotNull(message, Validator
                .MESSAGE_FOR_SOURCE_IF_NULL);
        printWriter.println(message);
        printWriter.flush();
        logger.addLoggerLine(this.getClass().getName()
                + ": sending message to the server...", false);
        ThreadUtility.sleep(183);
    }

    @Override
    public void start() {
        setUpNetworking(ipV4Address, port);
        chatUpdating();
    }

    @Override
    public void stop() {
        isStopped = true;
        try {
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        logger.addLoggerLine(this.getClass().getName()
                + ": socket closed...", false);
    }
}