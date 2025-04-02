package Collection;

import java.util.*;
import java.util.stream.Collectors;

public class MapSorter {
    public static Map<String, String> sortByValues(Map<String, String> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // Merge function in case of duplicate keys
                        LinkedHashMap::new // Preserve insertion order
                ));
    }

    public static void main(String[] args) {
        Map<String, String> unsortedMap = new HashMap<>();
        unsortedMap.put("a", "apple");
        unsortedMap.put("b", "banana");
        unsortedMap.put("c", "cherry");
        unsortedMap.put("d", "date");

        Map<String, String> sortedMap = sortByValues(unsortedMap);

        System.out.println("Sorted Map: " + sortedMap);
    }
}
