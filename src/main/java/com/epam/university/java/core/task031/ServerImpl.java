package com.epam.university.java.core.task031;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ServerImpl {
    private ArrayList readyClientOutputStreams;
    //added for version with ExecutorSerice
    private ExecutorService threadpool;

    class clientHandler implements Runnable{
        BufferedReader bufferedReader;


        public clientHandler(Socket clientSocket){
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        public void run(){
            String textLine;
            try {
                while((textLine=bufferedReader.readLine())!=null){
                    resender(textLine);
                }
            }
            catch (Exception ex){ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new ServerImpl().GStart();
    }
    public void GStart(){
        readyClientOutputStreams = new ArrayList();
        try {
            ServerSocket serverSocket = new ServerSocket(64319);
            System.out.println("server is waiting for connection...");
            /*JHF versionnew Thread inpStream and resending
            while(true){
                //main thread listens the connection to be made to this socket and accepts it
                Socket clientSocket = serverSocket.accept();
                PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
                readyClientOutputStreams.add(printWriter);
                         new Thread(new clientHandler(clientSocket)).start();
                            }*/
            threadpool = Executors.newFixedThreadPool(9);
            for (;;) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
                readyClientOutputStreams.add(printWriter);

                threadpool.execute(new clientHandler(clientSocket));
            }
        }
        catch(Exception ex){ex.printStackTrace();
        }
    }
    public void resender(String textLine){
        Iterator iterator = readyClientOutputStreams.iterator();
        while (iterator.hasNext()){
            PrintWriter printWriter = (PrintWriter)iterator.next();
            printWriter.println(textLine);
            printWriter.flush();
        }
    }
}
