package task_8_MultyThreading.threadsImpl;

import task_8_MultyThreading.resource.Counter;
import static java.lang.String.format;

/**
 * This class implements and creates threads by extending of Thread
 * and using common resource
 *
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class ThreadImpl {
    private static Counter counter = new Counter();
    private static volatile int result, valBefore;

    public static void main(String[] args) {
        Thread thread = null;
        for (int i = 0; i < 10; i++) {
            thread = new Thread() {

                @Override
                public void run() {
                    doWork();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(format(Thread.currentThread().getName() +
                            ": valBefore = %d, result = %d", valBefore, result));
                }
            };

            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final result = " + result);
    }

    /**
     * Gets result from increment method
     */
    private synchronized static void doWork() {
        valBefore = result;

        for (int i = 0; i < 10; i++) {
            result += counter.count(i);
        }
    }
}
