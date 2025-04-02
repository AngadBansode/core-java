package array;

import java.util.HashMap;

public class TwoPhaseSum {

    public static int[] twoPhaseSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoPhaseSum(nums, target);
        if (result[0] == -1) {
            System.out.println("No two numbers sum up to " + target);
        } else {
            System.out.println("The two numbers that sum up to " + target + " are " + nums[result[0]] + " and " + nums[result[1]]);
        }
    }
}