package array;

import java.util.Arrays;

/*
 Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]


Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6]
 */
public class _2DArrayMeetingConflict {

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[] innerArr = arr[0];
//        int[] inner_next = arr[0 + 1];
        int[][] outputArray = new int[arr.length][arr[0].length];
//        System.out.println(Arrays.toString(innerArr));
//        System.out.println("deepArray inner next : " + Arrays.toString(inner_next));
//
//          innerArr = new int[2];
//        System.out.println("updated inner Array: " + Arrays.toString(innerArr));

        for (int i = 0; i < arr.length-1; i++) {

            int[] inner_array = arr[i];// 1,3
            int[] inner_next = arr[i + 1];// 2,6
            if (inner_array[1] > inner_next[0]) {
                outputArray[i][i] = inner_array[0];
                outputArray[i][i+1] = inner_next[1];
                i = i+1;

            }else{
                outputArray[i][0] = inner_array[0];
//                outputArray[i][i+1] = inner_next[1];

            }

            inner_array = new int[1];
            inner_next = new int[1];
        }

        System.out.println(Arrays.toString(outputArray[0]));

    }
}

