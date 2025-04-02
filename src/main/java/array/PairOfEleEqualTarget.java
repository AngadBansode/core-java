package array;

import java.util.HashMap;
import java.util.Map;

public class PairOfEleEqualTarget {

    public static void main(String[] args) {

        int arr[] = {1, 5, 6, 7, -1, 2};
        int target = 7;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int no = target - arr[i];
            if (map.containsKey(no)) {
                System.out.println(no + " " + arr[i]);
            } else {
                map.put(arr[i], i);
            }
        }
        System.out.println(map);
    }
}
