package com.epam.university.java.core.task031;

/**
 * Created by Вера on 12.10.2017.
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
