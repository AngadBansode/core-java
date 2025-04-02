package code;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNLastIndexDistinct {

    public static void main(String[] args) {

        Integer arr[] = {1 , 2, 2, 2, 2, 9, 4, 15, 8, 8, 1,100};
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.remove(arr[i]);
            } else
                map.put(arr[i], i);
        }

        System.out.println(map);

        // Get the first entry
        Map.Entry<Integer, Integer> firstEntry = map.entrySet().iterator().next();
        System.out.println("First entry: " + firstEntry.getKey() + " - " + firstEntry.getValue());

        // Get the last entry
        Map.Entry<Integer, Integer> last = null;
        Iterator<Map.Entry<Integer, Integer>> lastEntry = map.entrySet().iterator();
        while (lastEntry.hasNext()) {
            last = lastEntry.next();
        }
        System.out.println("Last entry: " + last.getKey() + " - " + last.getValue());
    }

}
