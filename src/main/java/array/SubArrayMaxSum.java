package array;

import java.util.Arrays;

// find the largest sub-array sum
public class SubArrayMaxSum {

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, -11}; // 9
//        int[] arr = {5, 4, -1, 7, 8}; // 23

        findLargestSum(arr);

    }

    private static void findLargestSum(int[] arr) {
        int pre = 0;
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum += arr[i];
            if (pre < sum) {
                pre = sum;
            } else {
                sum = 0;
//                i--;
            }
        }

        int totalSum = Arrays.stream(arr).sum();

        System.out.println("MaxSum: " + Math.max(pre, totalSum));
    }
}
