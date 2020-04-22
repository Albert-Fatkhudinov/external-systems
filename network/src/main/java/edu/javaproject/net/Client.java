package edu.javaproject.net;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 20; i++) {
            sendRequest();
        }
    }

    private static void sendRequest() throws IOException {

        Socket socket = new Socket("127.0.0.1", 25225);

        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        BufferedWriter bufferedWriter
                = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String name = "Albert";
        bufferedWriter.write(name);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        String answer = bufferedReader.readLine();

        System.out.println("client got answer: " + answer);

        bufferedReader.close();
        bufferedWriter.close();
    }
}
