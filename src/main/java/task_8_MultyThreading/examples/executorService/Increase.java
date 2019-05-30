package task_8_MultyThreading.examples.executorService;

/**
 * This class implements increase of value
 *
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class Increase {

    /**
     * Increases value and returns it
     *
     * @param a input value
     * @return result value
     */
    public Double count(double a) {
        for (int i = 0; i < 1000000; i++) {
            a = a + Math.tan(a);
        }

        return a;
    }
}
