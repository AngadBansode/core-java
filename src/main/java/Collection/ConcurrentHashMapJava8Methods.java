package Collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class ConcurrentHashMapJava8Methods {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Populate the map
        map.put("Apple", 3);
        map.put("Banana", 5);
        map.put("Cherry", 8);
        map.put("Date", 2);

        // 1. forEach - Print each key-value pair
        System.out.println("Using forEach:");
        map.forEach(1, (key, value) ->
                System.out.println("Key: " + key + ", Value: " + value)
        );

        // 2. search - Find a key-value pair where the value is greater than 4
        System.out.println("\nUsing search:");
        String found = map.search(1, (key, value) -> value > 4 ? key : null);
        System.out.println("Found: " + found);

        // 3. reduce - Sum all values in the map
        System.out.println("\nUsing reduce:");
        int sum = map.reduceValues(1, Integer::sum);
        System.out.println("Sum of values: " + sum);

        // 4. computeIfAbsent - Add a new key only if it's not already present
        System.out.println("\nUsing computeIfAbsent:");
        map.computeIfAbsent("Elderberry", key -> 10);
        System.out.println("Map after computeIfAbsent: " + map);

        // 5. computeIfPresent - Modify a value only if the key exists
        System.out.println("\nUsing computeIfPresent:");
        map.computeIfPresent("Apple", (key, value) -> value + 2);
        System.out.println("Map after computeIfPresent: " + map);

        // 6. merge - Merge a value into the map
        System.out.println("\nUsing merge:");
        map.merge("Banana", 3, Integer::sum); // Adds 3 to the existing value of "Banana"
        map.merge("notPresent", 3, Integer::sum); // same as put, if key not present already
        System.out.println("Map after merge: " + map);

        // 7. mappingCount - Get the estimated size of the map. same as size
        System.out.println("\nUsing mappingCount:");
        long count = map.mappingCount();
        System.out.println("Mapping count: " + count);
        System.out.println("size count: " + map.size());

        //8. replace
        map.replace("graps", 10); // if not present then dont do anything, if key present then replace value

    }
}
