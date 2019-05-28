package task_6_SortArray;

import java.util.Arrays;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println(Arrays.toString(array));

        sort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Sorts input array
     *
     * @param array input array to sort
     */
    public static void sort( int[] array)
    {
        int n = array.length;
        int maxValue = getMax(array, n);
        int exp = 1;
        int[] b = new int[n];

        while (maxValue / exp > 0)
        {
            int[] bucket = new int[10];

            for (int i = 0; i < n; i++) {
                bucket[(array[i] / exp) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                b[--bucket[(array[i] / exp) % 10]] = array[i];
            }
            for (int i = 0; i < n; i++) {
                array[i] = b[i];
            }

            exp *= 10;
        }
    }

    /**
     * Returns maximum value of array
     *
     * @param array input array
     * @param size size of array
     * @return maximum value of array
     */
    private static int getMax(int array[], int size) {
        int max = array[0];

        for (int i = 1; i < size; i++) {

            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }
}
