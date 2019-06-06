package task_8_MultyThreading.threadsImpl;

import task_8_MultyThreading.resource.Counter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

/**
 * This class threadPool with 2 active thread using ExecutorService
 * and this threads do any tasks
 *
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class FixedThreadPoolImpl {
    private static Counter counter = new Counter();
    private static volatile int result, valBefore;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                doWork();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(format(Thread.currentThread().getName() +
                        ": valBefore = %d, result = %d", valBefore, result));
            });
        }

        threadPool.shutdown();

        try {
            threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
