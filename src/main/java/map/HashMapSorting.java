package map;


import java.util.*;
import java.util.stream.Collectors;

public class HashMapSorting {
    public static void main(String[] args) {
        // Sample input HashMap
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("B", "Value2");
        hashMap.put("A", "Value1");
        hashMap.put("C", "Value3");
        hashMap.put("A", "DuplicateValue"); // Duplicate key "A" (new entry ignored, old value kept)

        // Sorting the HashMap by keys while retaining the old value for duplicate keys
        Map<String, String> sortedMap = hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey()) // Sort by keys
                .collect(Collectors.toMap(
                        Map.Entry::getKey,          // Extract key
                        Map.Entry::getValue,        // Extract value
                        (oldValue, newValue) -> oldValue, // Keep old value in case of duplicates
                        LinkedHashMap::new          // Use LinkedHashMap to maintain the order
                ));

        // Print the sorted map
        sortedMap.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }
}