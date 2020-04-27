package javaproject.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(25225, 20000);

        Map<String, Greetable> handlers = loadHandlers();


        System.out.println("Server is started");

        while(true) {
            Socket client = serverSocket.accept();
            new SimpleServer(client, handlers).start();
        }
    }

    private static Map<String, Greetable> loadHandlers() throws IOException {

        Map<String, Greetable> result = new HashMap<>();

        try (InputStream inputStream = Server.class.getClassLoader()
                .getResourceAsStream("server.properties")) {

            Properties properties = new Properties();
            properties.load(inputStream);

            for(Object command :properties.keySet()) {
                String className = properties.getProperty(command.toString());
                Class<Greetable> clazz = (Class<Greetable>) Class.forName(className);

                Greetable handler = clazz.getConstructor().newInstance();
                result.put(command.toString(), handler);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            throw  new RuntimeException(exception);
        }

        return result;
    }

}

class SimpleServer extends Thread {

    private Socket client;
    private Map<String, Greetable> handlers;

    public SimpleServer(Socket client, Map<String, Greetable> handlers) {
        this.client = client;
        this.handlers = handlers;
    }

    @Override
    public void run() {
        handleRequest();
    }

    private void handleRequest() {
       try {
           BufferedReader bufferedReader
                   = new BufferedReader(new InputStreamReader(client.getInputStream()));

           BufferedWriter bufferedWriter
                   = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

           String[] request = bufferedReader.readLine().split("\\s");
           String command = request[0];
           String userName = request[1];
           String id = request[2];
           System.out.println("Server got String1: " + command + " " + id);
           System.out.println("Server got String2: " + userName + " " + id);

           Thread.sleep(2000);

           String response = buildResponse(command, userName);
           bufferedWriter.write(response);
           bufferedWriter.newLine();
           bufferedWriter.flush();

           bufferedReader.close();
           bufferedWriter.close();

           client.close();
       } catch (Exception exception) {
           exception.printStackTrace(System.out);
       }
    }

    private String buildResponse(String command, String userName) {
        Greetable handler = handlers.get(command);
        if (handler != null) {
            return handler.buildResponse(userName);
        }
        return "Hello, " + userName;
    }
}
