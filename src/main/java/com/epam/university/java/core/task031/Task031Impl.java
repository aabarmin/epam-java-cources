package com.epam.university.java.core.task031;

public class Task031Impl implements Task031 {
    private final int port = 6000;

    public Client createClient() {
        return new ClientImpl(port);
    }

    @Override
    public Server createServer() {
        return new ServerImpl(port);
    }
}
