package array;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveSum {
    public static List<List<Integer>> consecutiveSum(int[] nums, int target) {
        int s = 0, e = 0;
        int tempTarget = 0;
        List<List<Integer>> res = new ArrayList<>();

        while (e < nums.length) {
            tempTarget += nums[e];
            if (tempTarget == target) {
                List<Integer> sublist = new ArrayList<>();
                for (int i = s; i <= e; i++) {
                    sublist.add(nums[i]);
                }
                res.add(sublist);
                tempTarget -= (nums[s] + nums[e]);
                s++;
            } else if (tempTarget > target) {
                tempTarget -= (nums[s] + nums[e]);
                s++;
            } else {
                e++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {11, 7, 2, 1, 3, 5, 3, 5, 10, 34, 8, 5};
        int target = 13;
        List<List<Integer>> result = consecutiveSum(nums, target);
        System.out.println(result);
    }
}