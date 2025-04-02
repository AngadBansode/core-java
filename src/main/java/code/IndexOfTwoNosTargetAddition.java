package code;

import java.util.HashMap;
import java.util.Map;

public class IndexOfTwoNosTargetAddition {

    public static int[] findTwoSumIndices(int[] nums, int target) {
        Map<Integer, Integer> numIndices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numIndices.containsKey(complement)) {
                return new int[]{numIndices.get(complement), i};
            }

            numIndices.put(nums[i], i);
        }

        return null; // If no solution is found
    }

    public static void main(String[] args) {
        int  nums[] = {4,7,2,1,3,8,51};
        int target = 5;

        int[] result = findTwoSumIndices(nums, target);

        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found.");
        }
    }
}
