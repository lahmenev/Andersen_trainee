package task_8_MultyThreading.threadsImpl;

import task_8_MultyThreading.resource.Counter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.lang.String.format;

/**
 * This class create single thread using ExecutorService that does any tasks
 *
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class SingleThreadPoolImpl {
    private static Counter counter = new Counter();
    private static volatile int result, valBefore;

    public static void main(String[] args){
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            threadPool.submit(() -> {
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

        while (!threadPool.isTerminated()) {

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
