package task_6_SortArray;

import java.util.Arrays;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println(Arrays.toString(array));

        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Sorts input array
     *
     * @param array input array
     * @param leftBorder left border of array
     * @param rightBorder right border of array
     */
    private static void sort(int[] array, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker + rightMarker) / 2];

        do {

            while (array[leftMarker] < pivot) {
                leftMarker++;
            }

            while (array[rightMarker] > pivot) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {

                if (leftMarker < rightMarker) {
                    int tmp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = tmp;
                }

                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);


        if (leftMarker < rightBorder) {
            sort(array, leftMarker, rightBorder);
        }

        if (leftBorder < rightMarker) {
            sort(array, leftBorder, rightMarker);
        }
    }
}
