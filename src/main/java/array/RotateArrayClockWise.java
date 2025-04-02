package array;

import java.util.Arrays;

public class RotateArrayClockWise {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int d = 12;

        System.out.println("Original Array: " + Arrays.toString(array));
        rotateClockwise(array, d);
        System.out.println("Rotated Array: " + Arrays.toString(array));
    }

    public static void rotateClockwise(int[] array, int d) {
        int n = array.length;
        d = d % n; // Handle cases where d > n

        // Reverse the entire array
        reverse(array, 0, n - 1);

        // Reverse the first 'd' elements
        reverse(array, 0, d - 1);

        // Reverse the remaining elements
        reverse(array, d, n - 1);
    }

    private static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

}
