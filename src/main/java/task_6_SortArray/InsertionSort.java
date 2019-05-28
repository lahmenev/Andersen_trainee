package task_6_SortArray;

import java.util.Arrays;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {10, 2, 10, 3, 1, 2, 5};

        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Sorts input array
     *
     * @param array input array to sort
     */
    private static void sort(int[] array) {
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;

            for (; i >= 0; i--) {

                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
    }
}
