package code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PossibleCombinations2 {

    public static void main(String[] args) {
        /*
         * Example : [1,2,3,2,10,14,19,11,3,7,9,13] Output : Longest increasing
         * subsequence length : 4 All possible subsequences : 2,10,14,19 3,7,9,13
         */

        Integer arr[] = {1, 2, 3, 2, 5, 10, 12, 14, 11, 3, 4, 7, 1, 2, 3, 4, 5, 6, 7, 3, 4,8,12,16,20,25,30,35};// 11

        List<Integer> elements = new ArrayList<>();
        Map<Integer, List<Integer>> maps = new HashMap<>();
        int sequence = 0;
        int max = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] < arr[i + 1]) {
                sequence++;
                elements.add(arr[i]);
            } else {
                max = Math.max(max, sequence);
                maps.put(sequence + 1, new ArrayList<>(elements));
                elements.clear();
                sequence = 0;
            }
            maps.put(sequence + 1, new ArrayList<>(elements));
        }


        System.out.println(max + 1);

        var first = maps.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).findFirst();

        System.out.println(first.get());

        List<?> list = new ArrayList<>();



    }
}
