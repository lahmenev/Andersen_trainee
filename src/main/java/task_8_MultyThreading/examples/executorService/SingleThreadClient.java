package task_8_MultyThreading.examples.executorService;

import static java.lang.String.format;

/**
 * This class does any increment operation in single main thread
 *
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class SingleThreadClient {

    public static void main(String[] args) {
        Increase counter = new Increase();

        long start = System.nanoTime();

        double value = 0;
        for (int i = 0; i < 400; i++) {
            value += counter.count(i);
        }

        System.out.println(format("Executed by %d s, value : %f",
                (System.nanoTime() - start) / (1000_000_000),
                value));
    }
}
