package task_7_Socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class Server {
    private static final int PORT = 4004;
    static ServerSocket server;

    /**
     * Main method for server
     *
     * @param args parameter for method
     */
    public static void main(String[] args) throws IOException {
        server = new ServerSocket(PORT);
        System.out.println("Сервер запущен");
        try {

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Клиент присоединился");
                try {
                    new ServerService(clientSocket);
                } catch (IOException e) {
                    clientSocket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}
