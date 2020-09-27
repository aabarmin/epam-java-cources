package com.epam.university.java.core.task031;

/**
 * Author Dmitry Novikov 10-Sep-20.
 */
public class Task031Impl implements Task031 {
    /**
     * Create chat client.
     *
     * @return chat client instance
     */
    @Override
    public Client createClient() {
        return new ClientImpl();
    }

    /**
     * Create chat server.
     *
     * @return chat server instance
     */
    @Override
    public Server createServer() {
        return new ServerImpl();
    }
}