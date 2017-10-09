package com.epam.university.java.core.task031;

public class Task031Impl implements Task031 {

    public Client createClient() {
        return new ClientImpl(6000);
    }

    @Override
    public Server createServer() {
        return new ServerImpl(6000);
    }
}
