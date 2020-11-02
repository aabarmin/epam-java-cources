package com.epam.university.java.core.task031;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientImpl implements Client{

    Socket socket;
    @Override
    public void sendMessage(String message) {
        
    }

    @Override
    public void start() {
        try{
            socket = new Socket("localhost", 44444);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void stop() {

    }
}
