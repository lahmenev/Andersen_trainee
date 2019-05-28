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
            out.println("Добро пожаловать, " + clientString);
            try {
                while (true) {
                    clientString = in.readLine();

                    if(clientString.equals("stop")) {
                        this.stopService();
                        break;
                    }

                    if (clientString.contains("погода")) {
                        out.println("Сегодня ясная погода");
                    } else if (clientString.contains("дата")) {
                        Date date = new Date();
                        out.println(date.toString());
                    } else if (clientString.contains("поесть") || clientString.contains("пообедать")) {
                        out.println("На Невском проспекте 65 есть хорошее место");
                    } else {
                        out.println("К сожалению, я не могу ответить на этот вопрос");
                    }

                    System.out.println("Сообщения от клиента : " + clientString);
                }
            } catch (NullPointerException n) {
                n.printStackTrace();
            }

        } catch (IOException e) {
            this.stopService();
        }
    }

    /**
     * Terminates server
     */
    private void stopService() {
        try {

            if (!clientSocket.isClosed()) {
                clientSocket.close();
                in.close();
                out.close();
                Server.server.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
