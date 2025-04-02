package streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringRepeatingElement {

    public static void main(String[] args) {
        String input = "ilovejavacoding";


        // 1. repeating element
        var collect = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(values -> values.getValue() > 1)
//                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(collect);

       // 2. non-repeating

        var nonRepeating = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(values -> values.getValue() == 1)
//                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(nonRepeating);

        // 3. first repeating
        var firstRepeating = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(values -> values.getValue() > 1)
//                .map(Map.Entry::getKey)
                .findFirst().orElseGet(null);
        System.out.println(firstRepeating);

        // 4. first non-repeating
        var firstNonRepeating = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(values -> values.getValue() == 1)
//                .map(Map.Entry::getKey)
                .findFirst().orElseGet(null);
        System.out.println(firstNonRepeating);

        // 5. find the longest length from given array
        String arr[] = {"angad","chetana","raj","chetanh"};

        var first = Arrays.stream(arr)
                .reduce((word1, word2) -> word1.length() > word2.length()? word1: word2)
                .get();
        System.out.println(first);

    }

}
