package com.heatheryou.echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void start(String[] args) throws IOException {
        int port = 5000;

        try (
                ServerSocket serverSocket = new ServerSocket(port);
                Socket clientSocket = serverSocket.accept();
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                )
        {
            String inputLine;
            while ((inputLine = input.readLine()) != null) {
                output.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when listening to port " + port);
            System.out.println(e.getMessage());
        }
    }
}