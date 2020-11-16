package com.epam.university.java.core.task031;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task031Test {
    private Task031 factory;

    @Before
    public void setUp() throws Exception {
        factory = TestHelper.getInstance(Task031.class);
    }

    @Test
    public void testSingleClientNoMessages() throws Exception {
        final Server server = factory.createServer();
        final Client client = factory.createClient();
        //
        server.start();
        client.start();
        //
        assertEquals("Client didn't send any messages",
                "",
                server.readMessage()
        );
        //
        server.stop();
        client.stop();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSingleClientNullMessage() throws Exception {
        final Server server = factory.createServer();
        final Client client = factory.createClient();
        //
        server.start();
        client.start();
        //
        client.sendMessage(null);
        //
        server.stop();
        client.stop();
    }


    @Test
    public void testSingleClientOneMessage() throws Exception {
        final Server server = factory.createServer();
        final Client client = factory.createClient();
        //
        server.start();
        client.start();
        //
        final String message = "Hello, world!";
        client.sendMessage(message);
        //
        assertEquals("Server didn't received message",
                message,
                server.readMessage()
        );
        assertEquals("Where are no messages left",
                "",
                server.readMessage()
        );
        //
        server.stop();
        client.stop();
    }

    @Test
    public void testSingleClientSeveralMessages() throws Exception {
        final Server server = factory.createServer();
        final Client client = factory.createClient();
        //
        server.start();
        client.start();
        //
        final String message1 = "Hello, world!";
        final String message2 = "Winter is coming!";
        client.sendMessage(message1);
        client.sendMessage(message2);
        //
        assertEquals("Server didn't received message2",
                message2,
                server.readMessage()
        );
        assertEquals("Server didn't received message1",
                message1,
                server.readMessage()
        );
        assertEquals("Where are no messages left",
                "",
                server.readMessage()
        );
        //
        server.stop();
        client.stop();
    }

    @Test
    public void testMultipleClients() throws Exception {
        final Server server = factory.createServer();
        final Client client1 = factory.createClient();
        final Client client2 = factory.createClient();
        //
        server.start();
        client1.start();
        client2.start();
        //
        final String message1 = "Hello, world!";
        final String message2 = "Winter is coming!";
        client1.sendMessage(message1);
        client2.sendMessage(message2);
        //
        assertEquals("Server didn't received message2",
                message2,
                server.readMessage()
        );
        assertEquals("Server didn't received message1",
                message1,
                server.readMessage()
        );
        assertEquals("Where are no messages left",
                "",
                server.readMessage()
        );
        //
        server.stop();
        client1.stop();
        client2.stop();
    }
}