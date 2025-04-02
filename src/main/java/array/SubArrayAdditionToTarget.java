package array;

import java.util.HashMap;
import java.util.Map;

public class SubArrayAdditionToTarget {

    public static void main(String[] args) {
        int arr[] = {12, 2, 11, 100, 7, 1, 5, 12, 1, 50, 11, 2, 12};
        // 7 2 1 3 = 13 and 8 5 = 13
        int target = 13;
        int add = 0;
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            add = add + arr[i];
            if (add == target) {
                map.put(index, i);
                add = 0;
                for (int j = index; j <= i; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println("------------" + 13);
                index = i;
                index++;

            } else if (arr[i] > target) {
                add = 0;
                index = i;
                index++;
            } else if (add > target) {
                add = add - arr[i - 1];
                index = i;
            }
        }
        System.out.println(map);

    }

}
