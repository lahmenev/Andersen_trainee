package task_8_MultyThreading.threadsImpl;

import task_8_MultyThreading.resource.Counter;
import static java.lang.String.format;

/**
 * This class implements Runnable and creates threads using common resource
 *
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class RunableImpl {
    private static Counter counter = new Counter();
    private static volatile int result, valBefore;

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Runnable task = () -> {
                doWork();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(format(Thread.currentThread().getName() +
                        ": valBefore = %d, result = %d", valBefore, result));
            };

            Thread thread = new Thread(task);
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
    private static synchronized void doWork() {
        valBefore = result;

        for (int i = 0; i < 10; i++) {
            result += counter.count(i);
        }
    }
}
