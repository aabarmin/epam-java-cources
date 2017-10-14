package com.epam.university.java.core.task031;

/**
 * Created by Александр on 09.10.2017.
 * Networking with streams.
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
