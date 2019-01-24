package com.heatheryou.echoserver;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting server...");
        try (EchoServer server = new EchoServer(new ServerSocketConnection(), new EchoConnectionHandler())) {
            server.start(5000);
        }
    }
}
