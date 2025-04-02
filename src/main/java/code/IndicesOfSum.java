package code;

import java.util.HashMap;
import java.util.Map;

// find the indices of element which sum is equal to target
public class IndicesOfSum {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 9, 11, 8, 32, 5,8};
        int target = 10;

        map.put(0, nums[0]);
        for (int i = 1; i < nums.length; i++) {

            if (map.containsValue(target - nums[i]))
            {
                System.out.println(findKeyByValue(target-nums[i]) + " " + i);
            }
            else
                map.put(i, nums[i]);
        }


    }

    private static int findKeyByValue(int i) {

       return    map.entrySet().stream().filter(entry -> entry.getValue() == i).findFirst().get().getKey();

    }
}
