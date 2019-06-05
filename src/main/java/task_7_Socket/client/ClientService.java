package task_7_Socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class ClientService {

    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    private BufferedReader reader;
    private int port;
    private String host;
    private static final String EXIT = "stop";

    /**
     * Initialization of client
     *
     * @param host host address of server
     * @param port port of sever
     */
     ClientService(String host, int port) {
        this.host = host;
        this.port = port;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)){

            this.clientSocket = new Socket(host, port);
            System.out.println("Connection to server is successful");

            System.out.println("Please, enter your name");
            out.println(reader.readLine());
            new ReadMsg().start();
            new WriteMsg().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Stops connection with server
     */
    private void stopService() throws IOException{

        try {

            if (!clientSocket.isClosed()) {
                clientSocket.close();
                in.close();
                out.close();
                reader.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
            out.close();
            reader.close();
        }
    }

    /**
     * Class for getting message from server.
     * It runs in another thread.
     */
    private class ReadMsg extends Thread {

        /**
         * Runs main logic for thread
         */
        @Override
        public void run() {

            while (true) {

                try {
                    String servString = in.readLine();

                    if (servString.equalsIgnoreCase(EXIT)) {
                        ClientService.this.stopService();
                        break;
                    }

                    System.out.println(servString);
                } catch (IOException e) {

                    try {
                        ClientService.this.stopService();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * Class for sending message to server.
     * It run in another thread
     */
    public class WriteMsg extends Thread {

        /**
         * Runs main logic for thread
         */
        @Override
        public void run() {

            while (true) {

                try {
                    String userString = reader.readLine();

                    if (userString.equalsIgnoreCase(EXIT)) {
                        out.println("stop");
                        ClientService.this.stopService();
                        break;
                    } else {
                        out.println(userString);
                    }

                } catch (IOException e) {

                    try {
                        ClientService.this.stopService();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
