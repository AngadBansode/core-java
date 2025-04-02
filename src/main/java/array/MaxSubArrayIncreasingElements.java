package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSubArrayIncreasingElements {

    public static void main(String[] args) {
        int arr[] = {11, 2, 3, 4, 12, 25, 28, 5, 20, 21, 39, 5, 1, 2, 3, 4, 10};

        printCombination(arr);
    }

    private static void printCombination(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> elements = new ArrayList<>(arr.length);
        int cnt = 1;
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                cnt++;
                elements.add(arr[i]);
            } else {
                elements.add(arr[i]);
                if (cnt > max)
                    map.put(cnt, new ArrayList<>(elements));
                if (cnt == max) {
                    List<Integer> list = new ArrayList<>(elements);
                    list.addAll(map.get(max));
                    map.put(cnt, list);
                }
                max = Math.max(max, cnt);
                cnt = 1;
                elements.clear();
            }
        }

        if (cnt > max) {
            elements.add(arr[arr.length - 1]);
            map.put(cnt, new ArrayList<>(elements));
        } else if (cnt == max) {
            elements.add(arr[arr.length - 1]);
            List<Integer> list = new ArrayList<>(elements);
            list.addAll(map.get(max));
            map.put(max, list);
        }
        System.out.println(map);
        System.out.println(map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getKey)));
    }
}
