package com.epam.university.java.core.task031;

public class Task031Impl implements Task031 {
    private static final int PORT = 9991;

    @Override
    public Client createClient() {
        return new ClientImpl(PORT);
    }

    @Override
    public Server createServer() {
        return new ServerImpl(PORT);
    }
}
