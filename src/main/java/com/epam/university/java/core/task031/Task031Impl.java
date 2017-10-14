package com.epam.university.java.core.task031;

import com.epam.university.java.core.utils.common.ThreadUtility;

/**
 * Created by Admin on 13.10.2017.
 */
public class Task031Impl implements Task031 {
    ServerImpl server;
    ClientImpl client;

    @Override
    public Client createClient() {
        client = new ClientImpl(server.getPort());
        ThreadUtility.sleep(183);
        return client;
    }

    @Override
    public Server createServer() {
        server = new ServerImpl();
        ThreadUtility.sleep(183);
        return server;
    }
}
