package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// miscellaneous - Java 8 streams
public class Miscellaneous {

    public static void main(String[] args) {

        // 1. partition by even odd nos counting
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        var longMap = list.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0, Collectors.counting()));
        System.out.println(longMap);

        // 2. array ele start with 1
        Integer[] arr = {10, 15, 8, 49, 25, 98, 32};
        Arrays.stream(arr)
                .map(ele -> ele + "")
                .filter(startWith -> startWith.startsWith("1"))
                .forEach(System.out::print);
        // 3. do the array sum and find 2nd highest sum
        // 1 2 3 4 = sum = 10 , 2nd highest sum = 9
        System.out.println("-------------------------------------------------------------");
        Integer[] arr2 = {1, 2, 3, 4};
        int _2ndHighestSUm = Arrays.stream(arr2)
                .sorted()
                .skip(1)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("2nd HighestSum : " + _2ndHighestSUm);

        // 4. max ele from array
        Optional<Integer> maxdata = Optional.of(Arrays.stream(arr2)
                .max(Comparator.naturalOrder())).orElse(Optional.of(0));
        System.out.println("Max data : " + maxdata.orElse(0));

        // 5. find the 1st non-repeating char fron given string
        String input = "Java articles are Awesome";

        var firstNonRepeatingChar = input.chars()
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .get().getKey();
        System.out.println("First non repeating char : " + firstNonRepeatingChar);

    }
}
