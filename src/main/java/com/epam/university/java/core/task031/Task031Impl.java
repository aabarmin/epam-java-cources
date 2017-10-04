package com.epam.university.java.core.task031;

/**
 * Networking with streams.
 */
public class Task031Impl implements Task031 {

    private static final int port = 7070; // random number actually

    /**
     * Create chat client.
     * @return chat client instance
     */
    @Override
    public Client createClient() {
        return new ClientImpl(port);
    }

    /**
     * Create chat server.
     * @return chat server instance
     */
    @Override
    public Server createServer() {
        return new ServerImpl(port);
    }

}
