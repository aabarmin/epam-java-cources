package com.epam.university.java.core.task031;

public class Task031Impl implements Task031 {
    private final int port = 6000;
    
    /**
     * Create chat client.
     *
     * @return chat client instance
     */
    @Override
    public Client createClient() {
        return new ClientImpl(port);
    }

    /**
     * Create chat server.
     *
     * @return chat server instance
     */
    @Override
    public Server createServer() {
        return new ServerImpl(port);
    }
}
