package task_7_Socket.client;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 4004;

    /**
     * Main method for client
     *
     * @param args parameter for method
     */
    public static void main(String[] args) {
        new ClientService(HOST, PORT);
    }
}
