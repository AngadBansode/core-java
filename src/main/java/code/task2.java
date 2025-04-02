package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class task2 {
    public static void main(String[] args) {
        int[] a = {12, 31, 245, 23};

        List<String> stringList = Arrays.stream(a).boxed().map(str -> str + "").collect(Collectors.toList());
//         List Arrays.asList(a);
        Map<Character, String> map = new HashMap<>();
        System.out.println(stringList.size());
        for (int i = 0; i < stringList.size(); i++) {

            if (map.containsKey(stringList.get(i).charAt(0))) {
                System.out.println(stringList.get(i));
                int finalI = i;
                map.computeIfPresent(stringList.get(i).charAt(0), (key, val) -> val + ", " + stringList.get(finalI));
            } else {
                map.put(stringList.get(i).charAt(stringList.get(i).length() - 1), stringList.get(i) + "," + map.getOrDefault(i, stringList.get(i)));
            }

        }
        System.out.println(map);
    }
}


