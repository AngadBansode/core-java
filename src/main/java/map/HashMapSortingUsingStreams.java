package map;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapSortingUsingStreams {
    public static void main(String[] args) {
        // Sample input HashMap with duplicate entries
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("B", "Value2");
        hashMap.put("A", "Value1"); // A -- Value1
        hashMap.put("C", "Value3");
        hashMap.put("A", "DuplicateValue"); // Duplicate key "A" (will not override old value)

        // Keep the old value for duplicate key "A"
      //  HashMap<String, String> mapWithOldValues = addKeepingOldValue(hashMap, "A", "NewValue");

        // Sort the HashMap by keys using Java 8 Streams
        Map<String, String> sortedMap = hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey()) // Sort by keys
                .collect(Collectors.toMap(
                        Map.Entry::getKey,          // Key mapper
                        Map.Entry::getValue,        // Value mapper
                        (oldValue, newValue) -> oldValue, // Merge function in case of conflict
                        LinkedHashMap::new          // Preserve insertion order of sorted entries
                ));

        // Print the sorted map
        sortedMap.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }

    // Method to add entries while keeping old value in case of duplicate keys
    private static HashMap<String, String> addKeepingOldValue(HashMap<String, String> map, String key, String newValue) {
        map.putIfAbsent(key, newValue); // Add the entry only if the key does not exist
        return map;                     // Return the updated map
    }
}