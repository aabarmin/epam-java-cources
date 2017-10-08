package com.epam.university.java.core.task031;

public class Task031Impl implements Task031 {
    @Override
    public Client createClient() {
        return ClientImpl.getInstance();
    }

    @Override
    public Server createServer() {
        return ServerImpl.getIstance();
    }
}
