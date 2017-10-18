package com.epam.university.java.core.task031;

import com.epam.university.java.core.utils.common.ThreadUtility;

/**
 * Class implements <code>Task031</code> interface.
 */
public class Task031Impl implements Task031 {
    private ServerImpl server;
    private ClientImpl client;

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
