package task_6_SortArray;

import java.util.Arrays;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class SelectionSort {

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
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int min = array[minIndex];

            for (int j = i; j < array.length; j++) {

                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    /**
     * Swaps two elements by ascending
     *
     * @param array input array
     * @param ind1 first index
     * @param ind2 second index
     */
    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}
