package task_9_StreamAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class StreamAPI {

    public static void main(String[] args) {
        System.out.println("----- FIRST SUBTASK -----");
        System.out.println();

        firstSubTask();

        System.out.println("\n");
        System.out.println("----- SECOND SUBTASK ---- \n");

        exceptionalCase();
    }

    /**
     * Creates stream from collection and does any non-terminal operations with stream.
     * Finally, method displays result data using foreach and foreach terminal operations.
     */
    private static void firstSubTask() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(8);
        list.add(12);
        list.add(6);
        Collections.sort(list);

        Predicate<Integer> multiplyTwo = x -> (x % 2) == 0;

        System.out.println("Numbers are multiply of two:");

        Stream<Integer> multiplyStream = list.stream().filter(multiplyTwo);
        multiplyStream.forEach(x -> System.out.print(x + " "));

        System.out.println();
        System.out.println("Incrementing numbers:");

        Stream<Integer> increaseStream = list.stream().filter(multiplyTwo).map(x -> x + 1);
        increaseStream.forEach(x -> System.out.print(x + " "));

        System.out.println();
        System.out.println("Parallel calculation using forEach");

        Stream<Integer> mixedStream = list.stream().filter(multiplyTwo).map(x -> x + 1);
        mixedStream.parallel().forEach(x -> System.out.print(x + " "));

        System.out.println();
        System.out.println("Parallel calculation using forEach ordered");

        Stream<Integer> orderedStream = list.stream().filter(multiplyTwo).map(x -> x + 1);
        orderedStream.forEach(x -> System.out.print(x + " "));
    }

    /**
     * Creates stream from collection.
     * Firstly, adds three elements into list, then creates stream from list.
     * Finally three elements more are added and stream displays into console.
     * Result of this: 1 2 3 4 5 6
     */
    private static void exceptionalCase() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Collections.sort(list);

        Stream<Integer> stream = list.stream();

        list.add(4);
        list.add(5);
        list.add(6);

        stream.forEach(x -> System.out.print(x + " "));
    }
}
