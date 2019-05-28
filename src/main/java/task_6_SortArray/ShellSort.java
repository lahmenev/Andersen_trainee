package task_6_SortArray;

import java.util.Arrays;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {4, 3, 7, 2, 1, 9, 5, 6};

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
        int gap = array.length / 2;

        while (gap >= 1) {
            for (int rigth = 0; rigth < array.length; rigth++) {
                for (int c = rigth - gap; c >= 0; c -= gap) {

                    if (array[c] > array[c + gap]) {
                        swap(array, c, c + gap);
                    }
                }
            }

            gap = gap / 2;
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
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }
}
