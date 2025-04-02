package array;

import java.util.Arrays;

import static org.apache.commons.lang3.ArrayUtils.contains;

public class NthLargestNoFromArray {

    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 40, 50, 35};
        int N = 3;

        int nthLargest = findNthLargestWithoutSorting(arr, N);
        System.out.println(N + "th Largest: " + nthLargest);
    }

    private static int findNthLargestWithoutSorting(int[] arr, int N) {
        if (arr == null || arr.length < N) {
            throw new IllegalArgumentException("Array must have at least N elements.");
        }
        int[] largestElements = new int[N];
        Arrays.fill(largestElements, Integer.MIN_VALUE);
        for (int i = 0; i < N; i++) {
            int largest = Integer.MIN_VALUE;
            for (int number : arr) {
                if (number > largest && !contains(largestElements, number)) {
                    largest = number;
                }
            }
            largestElements[i] = largest;
        }
        return largestElements[N - 1];
    }
}
