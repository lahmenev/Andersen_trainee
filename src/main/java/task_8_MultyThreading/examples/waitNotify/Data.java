package task_8_MultyThreading.examples.waitNotify;

/**
 * Common data for wait and notify example
 *
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class Data {
    private String packet;
    private boolean transfer = true;

    /**
     * Sends data when boolean flag is true
     *
     * @param packet common data
     */
    public synchronized void send(String packet) {

        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        transfer = false;
        this.packet = packet;
        notifyAll();
    }

    /**
     * Gets data when boolean flag is false
     *
     * @return common resource
     */
    public synchronized String receive() {

        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        transfer = true;
        notifyAll();
        return packet;
    }
}
