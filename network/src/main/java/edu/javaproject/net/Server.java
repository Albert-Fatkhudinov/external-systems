package edu.javaproject.net;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(25225);

        System.out.println("Server is started");

        while(true) {
            Socket client = serverSocket.accept();
            handleRequest(client);
        }
    }

    private static void handleRequest(Socket client) throws IOException {

        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(client.getInputStream()));

        BufferedWriter bufferedWriter
                = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        StringBuilder stringBuilder = new StringBuilder("Hello, ");
        String userName = bufferedReader.readLine();
        System.out.println("server got string: " + userName);

        stringBuilder.append(userName);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();

        client.close();
    }
}
