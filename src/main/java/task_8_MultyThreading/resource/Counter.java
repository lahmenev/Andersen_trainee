package task_8_MultyThreading.resource;

/**
 * This class implements operation to increase common value
 *
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class Counter {

    /**
     * Increases value and returns result
     *
     * @param a value that should to increase
     * @return result value
     */
    public int count(int a) {
        for (int i = 0; i < 1000; i++) {
            a++;
        }

        return a;
    }
}
