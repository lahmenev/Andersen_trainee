package task_6_SortArray;

import java.util.Arrays;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class ShuttleSort {

    public static void main(String[] args) {
        int[] array = {4, 6, 1, 2, 5};

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
        for (int i = 1; i < array.length; i++) {

            if (array[i] < array[i - 1]) {
                swap(array, i, i - 1);
                for (int j = i - 1; (j - 1) >= 0; j--) {

                    if (array[j] < array[j - 1]) {
                        swap(array, j, j - 1);
                    } else {
                        break;
                    }
                }
            }
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
