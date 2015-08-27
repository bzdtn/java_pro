package com.bezditnyi.homework.lesson3.http_server;

public class Main {
    public static void main(String[] args) {
        String myPath = "src/java/com/bezditnyi/homework/lesson3/http_server"; //"C:\\temp"
        HTTPServer server = new HTTPServer(8080, myPath);
        server.start();

        System.out.println("Server started...");

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                server.stop();
                System.out.println("Server stopped!");
            }
        });
    }
}
