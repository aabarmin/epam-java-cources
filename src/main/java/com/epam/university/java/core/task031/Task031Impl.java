package com.epam.university.java.core.task031;

/**
 * Implementation class for Task031.
 *
 * @author Sergei Titov
 */
public class Task031Impl implements Task031 {

    protected final static Object monitor = new Object();

    protected final static int PORT = 7777;
    private final static ServerImpl server = new ServerImpl();

    /**
     * {@inheritDoc}
     */
    @Override
    public Client createClient() {
        return new ClientImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Server createServer() {

        return server;
    }
}
