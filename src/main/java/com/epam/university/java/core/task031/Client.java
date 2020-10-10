package com.epam.university.java.core.task031;

import java.io.IOException;

/**
 * Network chat client.
 */
public interface Client {
    /**
     * Send message to server.
     * @param message message text
     */
    void sendMessage(String message) throws IOException;

    /**
     * Start client.
     */
    void start() throws IOException;

    /**
     * Stop client.
     */
    void stop();
}
