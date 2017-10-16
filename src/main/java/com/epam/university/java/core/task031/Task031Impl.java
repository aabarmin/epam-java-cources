package com.epam.university.java.core.task031;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Task031Impl implements Task031 {
    private int port = 6011;
    // Random random = new Random();


    @Override
    public Client createClient() {
        ClientImpl client = new ClientImpl(port);
        return client;
    }

    @Override
    public Server createServer() {
        //port = random.nextInt(999);
        port++;
        ServerImpl server = new ServerImpl((port));
        return server;
    }
}
