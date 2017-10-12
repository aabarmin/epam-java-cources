package com.epam.university.java.core.task031;

/**
 * {@inheritDoc}
 */
public class Task031Impl implements Task031 {
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
        return new ServerImpl();
    }
}
