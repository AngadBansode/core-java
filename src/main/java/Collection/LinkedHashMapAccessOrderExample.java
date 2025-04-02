package Collection;

import java.util.LinkedHashMap;

public class LinkedHashMapAccessOrderExample {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, 0.75f, true); // Enable access order
        map.put(3, "Three");
        map.put(1, "One");
        map.put(2, "Two");

        System.out.println(map); // Output: {3=Three, 1=One, 2=Two}

        map.get(1); // Access key 1
        System.out.println(map); // Output: {3=Three, 2=Two, 1=One} (access order maintained)
    }
}