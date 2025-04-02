package Collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class SynchonizedMap {
    public static void main(String[] args) {
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
