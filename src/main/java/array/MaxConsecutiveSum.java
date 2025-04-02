package array;

// Given an array of integers, find the maximum sum of any contiguous subarray of the array.
//To find the maximum sum of k-consecutive numbers in an array, you can use the sliding window
//     technique, which ensures an O(n) time complexity. Here's the solution:
public class MaxConsecutiveSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 6, 7, 8};
        int k = 3;

        System.out.println(findTheMaxConsecutiveSum(arr, k));
    }

    private static int findTheMaxConsecutiveSum(int[] arr, int k) {

        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }
        int currentSum = maxSum;

        for (int j = k; j < arr.length; j++) {
            currentSum = currentSum + arr[j] - arr[j - k];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;// 21
    }
}


/**
 * Algorithm:
 * Calculate the sum of the first
 * 𝑘
 * k elements (initial window).
 * Slide the window by one element at a time:
 * Subtract the element leaving the window.
 * Add the element entering the window.
 * Keep track of the maximum sum during the sliding process.
 */
   //time complexity: O(n)
   //space complexity: O(1)
   //sliding window technique