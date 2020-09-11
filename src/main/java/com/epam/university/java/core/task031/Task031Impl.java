package com.epam.university.java.core.task031;

/**
 * Created by Romin Nuro on 11.09.2020 16:07.
 */
public class Task031Impl implements Task031 {
    public static final int PORT = 12385;

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
