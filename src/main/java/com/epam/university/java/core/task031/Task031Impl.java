package com.epam.university.java.core.task031;

import java.util.Random;

public class Task031Impl implements Task031 {
    private int port = new Random().nextInt(8000);

    public Task031Impl() {

    }

    @Override
    public Client createClient() {
        return ClientImpl.getInstance(port);
    }

    @Override
    public Server createServer() {
        return ServerImpl.getInstance(port);
    }
}
