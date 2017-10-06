package com.epam.university.java.core.task031;

/**
 * Networking with streams.
 */
public interface Task031 {
    /**
     * Create chat client.
     * @return chat client instance
     */
    Client createClient();

    /**
     * Create chat server.
     * @return chat server instance
     */
    Server createServer();
}
