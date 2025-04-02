package code;

import java.util.Arrays;
/*
 * Example : [1,2,3,2,10,14,19,11,3,7,9,13] Output : Longest increasing
 * subsequence length : 4 All possible subsequences : 2,10,14,19 3,7,9,13
 */
public class PossibleCombinations {
    public static void main(String[] args) {

        int arr[] = {1,2,3,2,10,14,19,11,3,7,9,13,4};
        int curCount = 1;
        int maxCount = 1;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int cur = arr[i];
            int prev = arr[i - 1];
            if (cur > prev) {
                curCount++;
                maxCount = Math.max(maxCount, curCount);
            } else {
                curCount = 1;
            }
        }
        System.out.println(maxCount);
        curCount = 1;
        int[] temp = new int[maxCount];
        temp[0] = arr[0];
        int k = 1;
        for (int i = 1; i < n; i++) {
            int cur = arr[i];
            int prev = arr[i - 1];
            if (cur > prev) {
                temp[k++] = cur;
                curCount++;
                if (curCount == maxCount) {
                    System.out.println(Arrays.toString(temp));
                    temp = new int[maxCount];
                    temp[0] = cur;
                    k = 1;
                }
            } else {
                curCount = 1;
                temp = new int[maxCount];
                temp[0] = cur;
                k = 1;
            }
        }
    }
}
