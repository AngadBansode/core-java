package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Find the longest increasing subsequence. Print the length and all the possible subsequences
 * Example :
 * [1,2,3,2,10,14,19,11,3,7,9,13]
 * Output :
 * Longest increasing subsequence length : 4
 * All possible subsequences :
 * 2,10,14,19
 * 3,7,9,13
 * optimized the code for better time complexity...pls don't go with O(n^2)
 */

public class PossibleCombinations3 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 10, 2, 10, 14, 19, 11, 2, 11, 3, 7, 9,2};
        longestIncreasingSubsequence(arr);
    }

    private static void longestIncreasingSubsequence(int[] arr) {
//        {1, 2, 3, 2, 10, 14, 19, 2, 11, 3, 7, 9, 13, 34};
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> tempList = new ArrayList<>();
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > arr[i - 1]) {
                cnt++;
                tempList.add(arr[i - 1]);
            } else {
                tempList.add(arr[i - 1]);
                if (map.containsKey(cnt)) {
                    tempList.addAll(map.get(cnt));
                    map.put(cnt, new ArrayList<>(tempList));
                } else
                    map.put(cnt, new ArrayList<>(tempList));
                tempList.clear();
                cnt = 1;
            }
        }

        if (map.containsKey(cnt)) {
            tempList.add(arr[arr.length - 1]);
            tempList.addAll(map.get(cnt));
            map.put(cnt, new ArrayList<>(tempList));
        } else {
            tempList.add(arr[arr.length - 1]);
            map.put(cnt, new ArrayList<>(tempList));
        }
        System.out.println(map);
        var sorted = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).findFirst().get();
        System.out.println(sorted);
    }
}

