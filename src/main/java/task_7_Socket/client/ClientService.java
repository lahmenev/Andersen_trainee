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

    /**
     * Initialization of client
     *
     * @param host host address of server
     * @param port port of sever
     */
     ClientService(String host, int port) {
        this.host = host;
        this.port = port;

        try {
            this.clientSocket = new Socket(host, port);
            System.out.println("Успешное подключение к серверу");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            System.out.println("Пожалуйста, введите ваше имя");
            out.println(reader.readLine());
            new ReadMsg().start();
            new WriteMsg().start();

        } catch (IOException e) {
            ClientService.this.stopService();
        }
    }

    /**
     * Stops connection with server
     */
    private void stopService() {
        try {

            if (!clientSocket.isClosed()) {
                clientSocket.close();
                in.close();
                out.close();
                reader.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Class for getting message from server. It run in another thread
     */
    private class ReadMsg extends Thread {
        /**
         * Runs main logic for thread
         */
        @Override
        public void run() {
            String servString;
            try {
                while (true) {
                    servString = in.readLine();

                    if (servString.equals("stop")) {
                        ClientService.this.stopService();
                        break;
                    }

                    System.out.println(servString);
                }

            } catch (IOException e) {
                ClientService.this.stopService();
            }
        }
    }

    /**
     * Class for sending message to server. It run in another thread
     */
    public class WriteMsg extends Thread {
        /**
         * Runs main logic for thread
         */
        @Override
        public void run() {

            while (true) {
                String userString;
                try {
                    userString = reader.readLine();

                    if (userString.equals("stop")) {
                        out.println("stop");
                        ClientService.this.stopService();
                        break;
                    } else {
                        out.println(userString);
                    }

                } catch (IOException e) {
                    ClientService.this.stopService();
                }
            }
        }
    }
}
