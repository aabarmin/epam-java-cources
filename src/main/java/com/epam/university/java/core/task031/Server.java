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
    String readMessage() throws IOException;

    /**
     * Start chat server.
     */
    void start() throws IOException;

    /**
     * Stop chat server.
     */
    void stop() throws IOException;
}
