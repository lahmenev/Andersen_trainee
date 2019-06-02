package task_10_FunctionalInterfaces;

import java.util.Comparator;
import java.util.function.*;

/**
 * This class contains a simple example for understanding functional interfaces.
 *
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Example with creating own functional interface");
        myInterface();

        System.out.println("\nPredicate functional interface example");
        System.out.println("Result of input data: " + predicate("test"));

        System.out.println("\nFunction functional interface example");
        System.out.println("Result of input data: " + function("123"));

        System.out.println("\nSupplier functional interface example");
        System.out.println(supplier("John").getName());

        System.out.println("\nConsumer functional interface example");
        consumer(600);

        System.out.println("\nComparator functional interface example");
        System.out.println(comparator());

        System.out.println("\nBinaryOperator functional interface example");
        System.out.println(binaryOperator(3, 4));
    }

    /**
     * Method contains own functional interface
     */
    private static void myInterface() {
        MyFInterface fInterface = () -> System.out.println("It is example of Functional interface");
        fInterface.print();
    }

    /**
     * Predicate method
     *
     * @param string input string
     * @return true if input string's length = 4
     */
    private static boolean predicate(String string) {
        Predicate<String> predicate = (s) -> s.length() == 4;
        return predicate.test(string);
    }

    /**
     * Function method
     *
     * @param string input string
     * @return integer value from string
     */
    private static Integer function(String string) {
        Function<String, Integer> toInteger = Integer::valueOf;
        return toInteger.apply(string);
    }

    /**
     * Supplier method
     *
     * @param name input string
     * @return new User
     */
    private static User supplier(String name) {
        Supplier<User> userSupplier = () -> new User(name);
        return userSupplier.get();
    }

    /**
     * Consumer method
     *
     * @param a input integer value
     */
    private static void consumer(int a) {
        Consumer<Integer> printer = x -> System.out.printf("%d dollars", x);
        printer.accept(a);
    }

    /**
     * Comparator method
     *
     * @return comparing value of two objects
     */
    private static int comparator() {
        Comparator<User> comparator = (u1, u2) -> u1.getName().compareTo(u2.getName());

        User user1 = new User("Flex");
        User user2 = new User("Alex");

        return comparator.compare(user1, user2);
    }

    /**
     * BinaryOperator method
     *
     * @param a first input value
     * @param b second input value
     * @return multiplying of two value
     */
    private static int binaryOperator(int a, int b) {
        BinaryOperator<Integer> multiply = (x, y) -> x * y;
        return multiply.apply(a, b);
    }

    /**
     * Class of user
     */
    public static class User {
        private String name;

        String getName() {
            return name;
        }

        User(String name) {
            this.name = name;
        }
    }
}
