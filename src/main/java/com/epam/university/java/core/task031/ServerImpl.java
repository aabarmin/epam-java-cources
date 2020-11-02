package com.epam.university.java.core.task031;

import javax.activation.DataHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerImpl implements Server {
    ServerSocket serverSocket = null;

    DataOutputStream out;
    DataInputStream in;

    @Override
    public String readMessage() {
        String entry;


        try {
            entry = in.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void start() {
        try {
            serverSocket = new ServerSocket(44444);
            Socket client = serverSocket.accept();
            out = new DataOutputStream(client.getOutputStream());
            in = new DataInputStream(client.getInputStream());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        try {
            out.close();
            in.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
