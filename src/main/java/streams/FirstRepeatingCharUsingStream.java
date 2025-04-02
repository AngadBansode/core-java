package streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatingCharUsingStream {

    public static void main(String[] args) {
        String str = "Welcome to India";
     // 1. way
        str.chars().mapToObj(c -> (char) c)
                .filter(first -> str.indexOf(first) != str.lastIndexOf(first))
                .findFirst().ifPresent(System.out::println);
    //2. way
        var characterLongEntry = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .findFirst()
                .orElse(null);

        System.out.println(characterLongEntry);
    }
}
