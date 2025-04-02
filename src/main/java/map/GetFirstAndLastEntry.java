package map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class GetFirstAndLastEntry {

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "One");
        linkedHashMap.put(2, "Two");
        linkedHashMap.put(3, "Three");

        // Get the first entry
        Map.Entry<Integer, String> firstEntry = linkedHashMap.entrySet().iterator().next();
        System.out.println("First entry: " + firstEntry.getKey() + " - " + firstEntry.getValue());

        // Get the last entry
        Map.Entry<Integer, String> last = null;
        Iterator<Map.Entry<Integer, String>> lastEntry = linkedHashMap.entrySet().iterator();
        while (lastEntry.hasNext()) {
            last = lastEntry.next();
        }
        System.out.println("Last entry: " + last.getKey() + " - " + last.getValue());

        Object  array =  linkedHashMap.entrySet().toArray()[linkedHashMap.size() - 1];
        System.out.println("array: " +array);

    }
}