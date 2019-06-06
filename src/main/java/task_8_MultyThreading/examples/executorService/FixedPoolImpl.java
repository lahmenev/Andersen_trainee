package task_8_MultyThreading.examples.executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static java.lang.String.format;

/**
 * This class uses own created threadPool with any threads
 * and does increment operations for any tasks
 *
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class FixedPoolImpl {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThreadPool threadPool = new MyThreadPool(5);
        Increase counter = new Increase();

        long start = System.nanoTime();
        List<Future<Double>> futures = new ArrayList<>();

        for (int i = 0; i < 400; i++) {
            final int j = i;
            futures.add(
                    CompletableFuture.supplyAsync(
                            () -> counter.count(j),
                            threadPool
                    ));
        }

        double value = 0;
        for (Future<Double> future : futures) {
            value += future.get();
        }

        System.out.println(format("Executed by %d s, value : %f",
                (System.nanoTime() - start) / (1000_000_000),
                value));

        threadPool.shutdown();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
