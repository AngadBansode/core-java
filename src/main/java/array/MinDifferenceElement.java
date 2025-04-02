package array;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*1.int arr [] = {1,23,5,12,6,2,11,0}

        min differe -- o/p-  1, 0 | 1, 2 | 5, 6*/
public class MinDifferenceElement {

    public static void main(String[] args) {
        int arr[] = {11, 23, 5, 12, 6, 1, 2, 0, 10};

        /*for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++)
                if (arr[i] + 1 == arr[j] || arr[i] - 1 == arr[j]) {
                    System.out.println(arr[i] + ": " + arr[j]);

                }
        }*/
        Map<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (treeMap.containsKey(arr[i] - 1)) {
                treeMap.put(arr[i] - 1, arr[i]);
            } else
                treeMap.put(arr[i], 0);
        }

        treeMap.entrySet().stream().filter(values -> values.getValue() > 0)
                .forEach(System.out::println);
    }
}
