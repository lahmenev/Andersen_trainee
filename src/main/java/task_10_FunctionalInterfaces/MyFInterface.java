package task_10_FunctionalInterfaces;

/**
 * This is own functional interface
 *
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
@FunctionalInterface
public interface MyFInterface {

    default void printDef() {
       System.out.println("Default method");
    }

    void print();
}
