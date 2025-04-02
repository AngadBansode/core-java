package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NestedMap {
    public static void main(String[] args) {
        // created Map of Map of Map and some data
        Map<String, Map<String, Map<String, String>>> nestedMap = new HashMap<>();
        // add some dummy data to nestedMap
        Map<String, Map<String, String>> innerMap = new HashMap<>();
        Map<String, String> innerInnerMap = new HashMap<>();
        innerInnerMap.put("1", "one");
        innerInnerMap.put("2", "two");
        innerMap.put("inner", innerInnerMap);
        nestedMap.put("outer", innerMap);
        System.out.println(nestedMap);

        getInnerMapEntry(nestedMap);
    }

    private static void getInnerMapEntry(Map<String, Map<String, Map<String, String>>> nestedMap) {

        // print key value of innerInnerMap using streams
        nestedMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .map(Map::entrySet)
                .flatMap(Set::stream)
                .map(Map.Entry::getValue)
                .map(Map::entrySet)
                .flatMap(Set::stream)
                .forEach(System.out::println);
    }
}
