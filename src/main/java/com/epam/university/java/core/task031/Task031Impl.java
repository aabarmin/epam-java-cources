package com.epam.university.java.core.task031;

import java.io.IOException;

/**
 * Created by ilya on 08.10.17.
 */
public class Task031Impl implements Task031 {

    @Override
    public Client createClient() {
        Client client = null;
        try {
            client =  new ClientImpl();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public Server createServer() {
        Server server = null;
        try {
            server =  new ServerImpl();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return server;
    }
}
