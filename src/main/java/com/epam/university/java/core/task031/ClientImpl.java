package com.epam.university.java.core.task031;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;

public class ClientImpl {
    private JTextArea incomingText;
    private JTextField outcomingText;
    private JButton sendButton;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private Socket socket;
    String ipAdress = "127.0.0.1";
    int TCP = 64319;

    public static void main(String[] args) {
        ClientImpl jhf_tests_simpleChatClient_518 = new ClientImpl();
        jhf_tests_simpleChatClient_518.GStart();
    }

    public void GStart() {
        setUpNetworking(ipAdress, TCP);
        startNewThread();
        setUpGUI(333, 333, 5, 100, 50, 15, ipAdress, TCP);

    }

    public void setUpGUI(int frameWidth, int frameHeight, int panelBorders, int QofJTextAreaRows, int QofJTextAreaColumns, int QofJTextFieldColumns, String ipAdress, int TCP) {
        JFrame jFrame = new JFrame("Ludacris client");
        //setUp panel
        JPanel jPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(jPanel, BoxLayout.Y_AXIS);
        jPanel.setLayout(boxLayout);
        jPanel.setBorder(BorderFactory.createEmptyBorder(panelBorders, panelBorders, panelBorders, panelBorders));
        //setUp JTa % add to pa
        incomingText = new JTextArea(QofJTextAreaRows, QofJTextAreaColumns);
        incomingText.setLineWrap(true);
        incomingText.setWrapStyleWord(true);
        incomingText.setEditable(false);
        JScrollPane jScrollPane = new JScrollPane(incomingText);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jPanel.add(jScrollPane);
        jPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        //setUo JTf % add to pa
        outcomingText = new JTextField(QofJTextFieldColumns);
        jPanel.add(outcomingText);
        jPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        //setUp b % add to pa
        sendButton = new JButton("Send");
        sendButton.addActionListener(new writeSocketStream());
        sendButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(sendButton);
        jPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        //setUp Jf
        jFrame.getContentPane().add(jPanel, BorderLayout.CENTER);
        jFrame.setSize(frameWidth, frameHeight);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public void setUpNetworking(String ipAdress, int TCP) {
        try {
            socket = new Socket(ipAdress, TCP);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());
            System.out.println("networking established...");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void startNewThread() {
        Thread threadReading = new Thread(new readSocketStream());
        threadReading.start();
    }

    class writeSocketStream implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            printWriter.println(outcomingText.getText());
            printWriter.flush();
            outcomingText.setText("");
            outcomingText.requestFocus();
        }
    }

    class readSocketStream implements Runnable {
        String textLine;

        public void run() {
            try {
                while ((textLine = bufferedReader.readLine()) != null) {
                    incomingText.append(textLine + "\n");
                    System.out.println("new text line added: " + textLine);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

