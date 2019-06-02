package task_7_Socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class ServerService extends Thread {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    /**
     * Initialization of server
     *
     * @param clientSocket socket of client
     */
    ServerService(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        start();
    }

    /**
     * Runs main logic for thread
     */
    @Override
    public void run() {
        String clientString;

        try {
            clientString = in.readLine();
            out.println("You are welcome, " + clientString);

            try {

                while (true) {
                    clientString = in.readLine();

                    if(clientString.equalsIgnoreCase("stop")) {
                        this.stopService();
                        break;
                    }

                    if (clientString.contains("погода")) {
                        out.println("It is sun today");
                    } else if (clientString.contains("date")) {
                        Date date = new Date();
                        out.println(date.toString());
                    } else if (clientString.contains("eat") || clientString.contains("drink")) {
                        out.println("There is good place on Nevsky 36");
                    } else {
                        out.println("Sorry, I can't answer to this question");
                    }

                    System.out.println("Messages from client : " + clientString);
                }

            } catch (NullPointerException n) {
                n.printStackTrace();
            }

        } catch (IOException e) {

            try {
                this.stopService();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Terminates server
     */
    private void stopService() throws IOException{
        try {

            if (!clientSocket.isClosed()) {
                clientSocket.close();
                in.close();
                out.close();
                Server.server.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
            out.close();
            Server.server.close();
        }
    }
}
