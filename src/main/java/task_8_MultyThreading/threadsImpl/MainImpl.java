package task_8_MultyThreading.threadsImpl;

import task_8_MultyThreading.resource.Counter;
import static java.lang.String.format;

/**
 * This class create one single main thread and do any operation with resource
 *
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class MainImpl {
    private static Counter counter = new Counter();
    private static int result, valBefore;

    public static void main(String[] args) {
        doWork();

        System.out.println(format(Thread.currentThread().getName() +
                ": valBefore = %d, result = %d", valBefore, result));
    }

    /**
     * Gets result from increment method
     */
    private static void doWork() {
        valBefore = result;

        for (int i = 0; i < 10; i++) {
            result += counter.count(i);
        }
    }
}
