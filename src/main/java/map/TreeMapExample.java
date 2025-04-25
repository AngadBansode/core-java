package map;

import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // Create a TreeMap
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // Add key-value pairs
        treeMap.put(3, "Apple");
        treeMap.put(1, "Banana");
        treeMap.put(4, "Cherry");
        treeMap.put(2, "Date");

        // Display the TreeMap
        System.out.println("TreeMap: " + treeMap);

        // Get first and last keys
        System.out.println("First Key: " + treeMap.firstKey());
        System.out.println("Last Key: " + treeMap.lastKey());

        // Get values based on keys
        System.out.println("Value for key 2: " + treeMap.get(2));

        // Remove an entry
        treeMap.remove(3);
        System.out.println("After Removal: " + treeMap);

        // Iteration
        for (var entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Custom comparator (descending order)
        TreeMap<Integer, String> descendingMap = new TreeMap<>((a, b) -> b - a);
        descendingMap.putAll(treeMap);
        System.out.println("Descending Order: " + descendingMap);
    }
}
