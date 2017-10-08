package com.epam.university.java.core.task031;

/**
 * Created by ilya on 08.10.17.
 */
public class Task031Impl implements Task031 {

    @Override
    public Client createClient() {
        return new ClientImpl();
    }

    @Override
    public Server createServer() {
        return new ServerImpl();
    }
}
