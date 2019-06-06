package task_8_MultyThreading.resource;

/**
 * Wrapper class using in map as value
 *
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class Resource {
    private String nameThread;
    private int valBefore, result;

    public Resource(int valBefore, String nameThread, int result) {
        this.valBefore = valBefore;
        this.nameThread = nameThread;
        this.result = result;
    }

    /**
     * Overrides method from Object class and returns string representation
     *
     * @return string with value before, result and name of current thread
     */
    @Override
    public String toString() {
        return "Resource{" +
                "valBefore=" + valBefore +
                ", nameThread='" + nameThread + '\'' +
                ", result=" + result +
                '}';
    }
}
