package com.epam.university.java.core.task031;

/**
 * Implementation class for Task031.
 *
 * @author Sergei Titov
 */
public class Task031Impl implements Task031 {

    protected static final int PORT = 7777;
    private static final ServerImpl server = new ServerImpl();

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
