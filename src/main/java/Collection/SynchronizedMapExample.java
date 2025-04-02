package Collection;
/*
Yes, a synchronized map (like the one created using Collections.synchronizedMap())
  can throw a ConcurrentModificationException
   if structural modifications are made during iteration without proper synchronization.

 */
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SynchronizedMapExample {
    public static void main(String[] args) {
       /* Map<String, String> syncMap = Collections.synchronizedMap(new HashMap<>());

        syncMap.put("1", "One");
        syncMap.put("2", "Two");
        syncMap.put("3", "Three");

        // Without explicit synchronization during iteration
        Iterator<String> iterator = syncMap.keySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            // Modifying the map structurally while iterating
            syncMap.put("4", "Four"); // This will throw ConcurrentModificationException
        }
*/
    // solution --you must explicitly synchronize the map during iteration:

        Map<String, String> syncMap = Collections.synchronizedMap(new HashMap<>());

        syncMap.put("1", "One");
        syncMap.put("2", "Two");
        syncMap.put("3", "Three");

        // Synchronize explicitly during iteration
        synchronized (syncMap) {
            Iterator<String> iterator = syncMap.keySet().iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
                // Safe to modify the map inside synchronized block
                syncMap.put("4", "Four");
            }
        }
    }
}
