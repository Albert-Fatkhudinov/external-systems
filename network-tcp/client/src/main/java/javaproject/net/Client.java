package javaproject.net;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            new SimpleClient(i).start();
        }
    }

}

class SimpleClient extends Thread {

    public static final String[] COMMAND = {
            "HELLO", "MORNING", "DAY", "EVENING"
    };

    private int cmdNumber;
    static int count = 1;

    public SimpleClient(int cmdNumber) {
        this.cmdNumber = cmdNumber;
    }

    @Override
    public void run() {
        try {

            Socket socket = new Socket("127.0.0.1", 25225);

            BufferedReader bufferedReader
                    = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedWriter bufferedWriter
                    = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String command = COMMAND[cmdNumber % COMMAND.length];
            String name = command + " ALBERT " + count++;
            bufferedWriter.write(name);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String answer = bufferedReader.readLine();

            System.out.println("client got answer: " + answer);

            bufferedReader.close();
            bufferedWriter.close();

        } catch (IOException exception) {
            exception.printStackTrace(System.out);
        }
    }

}
