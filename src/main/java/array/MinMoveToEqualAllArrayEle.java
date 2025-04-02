package array;

import java.util.Arrays;

import static array.SecondLargestNo.second;

/*Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
   In one move, you can increment or decrement an element of the array by 1.
    Test cases are designed so that the answer will fit in a 32-bit integer.
        Example 1:
        Input: nums = [1,2,3]
        Output: 2
        Explanation:
        Only two moves are needed (remember each move increments or decrements one element):
        [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
        Example 2:
        Input: nums = [1,10,2,9]
        Output: 16*/
public class MinMoveToEqualAllArrayEle {

 public static void minMoves(int [] arr) {
        int moves = 0;
        int second = second(arr);

        for (int i = 0; i < arr.length; i++) {

            if (second >= arr[i]) {
                moves += second - arr[i];
            } else
                moves += arr[i] - second; // 8 + (10 - 9)
        }
        System.out.println(moves);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
            minMoves(arr);

    }

    /*public static int minMoves2(int[] nums) {
        //sort the array
        Arrays.sort(nums);

        //Calculate the steps by tasking 2 pointers
        int i = 0;
        int j = nums.length - 1;
        int steps = 0;

        while (i < j) { // steps  = 2 +
            steps += (nums[j] - nums[i]);// 3-1 // 2 - 2= 0
            i++;
            j--;
        }
        return steps;
    }*/

}
