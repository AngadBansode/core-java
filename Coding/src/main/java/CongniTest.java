import java.util.*;
import java.util.stream.Collectors;

public class CongniTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9, 2, 1, 1, 3, 7, 2, 5, 9, 3);

        Set<Integer> unique = new HashSet<>();

        list.stream().filter(uni -> !unique.add(uni))
                .forEach(System.out::println);

        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1.hashCode() == str2.hashCode());
        System.out.println(str1 == str2);

        var optinal = list.stream().distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println(optinal);

        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("Charlie", 3);
        unsortedMap.put("Alice", 1);
        unsortedMap.put("Bob", 2);
        unsortedMap.put("Alice", 4); // Duplicate key "Alice", new value 4
        System.out.println("Before sorting: " + unsortedMap);
        // Sorting the map by keys and keeping the old value in case of duplicates
        Map<String, Integer> sortedMap = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, // Keep the old value if a key is duplicated
                        LinkedHashMap::new // Maintain insertion order
                ));

        // Printing the sorted map
        System.out.println("Sorted Map: " + sortedMap);
    }
}
