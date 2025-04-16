package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class CustomKey {
    private int id;
    private String name;

    public CustomKey(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomKey that = (CustomKey) o;
        return id == that.id && Objects.equals(name, that.name);
    }
}

public class CustomKeyExample {
    public static void main(String[] args) {
        Map<CustomKey, String> map = new HashMap<>();

        CustomKey key1 = new CustomKey(1, "KeyOne");
        CustomKey key2 = new CustomKey(1, "KeyOne"); // Same content as key1

        map.put(key1, "Value1");
        map.put(key2, "Value2"); // Replaces key1's value because equals() returns true

        System.out.println("Map size: " + map.size()); // Output: 1
        System.out.println("Map content: " + map);    // Output: {CustomKey@hash=Value2}
    }
}
