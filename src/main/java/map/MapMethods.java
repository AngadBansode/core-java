package map;

import java.util.HashMap;
import java.util.Map;

public class MapMethods {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);

        map.putIfAbsent("nine", 200);
        map.computeIfAbsent("ten", MapMethods::findAvg);
        map.computeIfAbsent("One", MapMethods::addMoreValue);
        map.computeIfPresent("Four", (k, v) -> v + 2);
        map.putIfAbsent("Three", map.get("Three") + 1);
        System.out.println(map);
    }

    private static Integer addMoreValue(String v) {
        System.out.println("One: " + v);
        return 10;
    }

    private static Integer findAvg(String r) {

        return r.length();
    }
}
