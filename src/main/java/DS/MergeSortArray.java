package DS;

import java.util.Arrays;

public class MergeSortArray {

    public static void main(String[] args) {

        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array: " + Arrays.toString(array));

        mergeSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void mergeSort(int[] array) {
        int n = array.length;
        if (n < 2)
            return;
        int middle = array.length / 2; // 6/2  = 3
        int[] left = new int[middle]; // 12 11 13
        int[] right = new int[array.length - middle]; //  5, 6, 7

        for (int i = 0; i < left.length; i++) {
            left[i] = array[i]; // copy first half of array to left array
        }

        for (int i = middle; i < array.length; i++) { // 5 6 7
            right[i - middle] = array[i]; // copy second half of array to right array
        }
        // call 1
            // left -- 12 11 13
            // right -- 5 6 7
        ///call 2
            // / left -- 12 // return n<2
            // right -- 11 13
        ///call 2.2 - array - 11 13
        ///     // left = 11 // return n<2
                // right 13 // return n<2


        mergeSort(left);
        mergeSort(right);

        System.out.println("left: " + Arrays.toString(left));
        System.out.println("right: " + Arrays.toString(right));

        merge(array, left, right); //11,12,13 --- 5 6 7

    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {

            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        // check remaining left & right elements
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
}
