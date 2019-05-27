package task_6_SortArray;

import java.util.Arrays;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {3, 5, 2, 6, 4, 1};
        System.out.println(Arrays.toString(array));

        int[] sortArray = sort(array);
        System.out.println(Arrays.toString(sortArray));
    }

    /**
     * Returns sorted array by recursive
     *
     * @param arr input array to sort
     * @return sorted array
     */
    public static int[] sort(int[] arr){

        if(arr.length < 2) {
            return arr;
        }

        int midleIndex = arr.length / 2;
        int[] arr1 = Arrays.copyOfRange(arr, 0, midleIndex);
        int[] arr2 = Arrays.copyOfRange(arr, midleIndex, arr.length);
        return merge(sort(arr1), sort(arr2));
    }

    /**
     * Returns marge array
     *
     * @param arr1 first half of array
     * @param arr2 second half of array
     * @return final marge sorted array
     */
    private static int[] merge(int[] arr1, int[] arr2) {
        int size = arr1.length + arr2.length;
        int[] buffer = new int[size];
        int ind1 = 0;
        int ind2 = 0;

        for (int i = 0; i < size; i++) {

            if (ind1 == arr1.length) {
                buffer[i] = arr2[ind2++];
            } else if (ind2 == arr2.length) {
                buffer[i] = arr1[ind1++];
            } else {

                if (arr1[ind1] < arr2[ind2]) {
                    buffer[i] = arr1[ind1++];
                } else {
                    buffer[i] = arr2[ind2++];
                }
            }
        }
        return buffer;
    }
}
