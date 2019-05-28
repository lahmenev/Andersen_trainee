package task_6_SortArray;

import java.util.Arrays;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] array = {1, 7, 9, 4};
        System.out.println(Arrays.toString(array));

        int[] sortedArray = sort(array, 9);
        System.out.println(Arrays.toString(sortedArray));
    }

    /**
     * Returns sorted array
     *
     * @param array input array to sort
     * @param maxValue maximum value of specified array
     * @return sorted array
     */
    private static int[] sort(int[] array, int maxValue) {
        int[] numsCounts = new int[maxValue + 1];

        for (int num : array) {
            numsCounts[num]++;
        }

        int[] sortedArray = new int[array.length];
        int currentSortedIndex = 0;

        for (int n = 0; n < numsCounts.length; n++) {
            int count = numsCounts[n];

            for (int k = 0; k < count; k++) {
                sortedArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }

        return sortedArray;
    }
}
