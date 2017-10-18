package com.epam.university.java.core.task031;

import java.io.IOException;

/**
 * Chat server.
 */
public interface Server {
    /**
     * Read last received message.
     * @return message text
     */
    String readMessage();

    /**
     * Start chat server.
     */
    void start();

    /**
     * Stop chat server.
     */
    void stop() throws IOException;
}
