package task_9_StreamAPI.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * This simple implementation contains inner class with data.
 * Main method creates List with data, creates stream and gets sum of Integer elements of wrapper class.
 *
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class StreamExamples2 {

    public static class Employee {
        String salary;

        Employee(String salary) {
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("1000"));
        list.add(new Employee("3000"));
        list.add(new Employee("5000"));

        int sum = list.stream()
                .map(employee -> employee.salary)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        System.out.println("salary sum = " + sum);
    }
}
