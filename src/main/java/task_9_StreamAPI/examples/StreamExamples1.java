package task_9_StreamAPI.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Simply example for understanding StreamAPI
 * There is adding three elements into List, creates stream and transforms elements to UpperCase.
 *
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class StreamExamples1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("El 1");
        list.add("El 2");
        list.add("El 3");

        Stream<String> stream = list.stream();
        Stream<String> lowerCaseStream = stream.map(String::toLowerCase);
        lowerCaseStream.forEach(System.out::println);
    }
}
