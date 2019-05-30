package task_8_MultyThreading.threadsImpl;

import task_8_MultyThreading.resource.Counter;
import task_8_MultyThreading.resource.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class implements and creates threads
 * that using common resource as map and put data and result into there.
 *
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class ThreadWithMap {
    private static Map<String, Resource> map = new LinkedHashMap<>();
    private static Counter counter = new Counter();
    private static volatile int valBefore, result;

    public static void main(String[] args) {
        Thread thread = null;

        for (int i = 0; i < 10; i++) {
            thread = new Thread() {

                @Override
                public void run() {
                    doWork();
                    map.put(Thread.currentThread().getName(), new Resource(valBefore, Thread.currentThread().getName(), result));
                }
            };

            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Map.Entry<String, Resource> entry : map.entrySet()) {
            System.out.println(entry.getValue());
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
