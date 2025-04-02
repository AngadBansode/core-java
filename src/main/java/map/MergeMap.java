package map;

import java.util.*;

public class MergeMap {
    public static void main(String[] args) {
    Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);
        map1.put("a", 4);
        map1.put("c", 5);

        var merge = map1.merge("a", map1.get("a"), Integer::sum);
        System.out.println(merge);
        System.out.println(map1);


        Map<String, String> map2 = new HashMap<>();
        map2.put("b", "4");
        map2.put("c", "5");
        map2.put("d", "6");



    }
}
