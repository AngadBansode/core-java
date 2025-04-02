package streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// String input = "ilovejavacoding"; find first non-repeating char
public class FirstNonRepeatingChar {

    public static void main(String[] args) {

        //1.  String input = "ilovejavacoding"; find first non-repeating char
        String input = "ilovejavacoding";
        Map<Character, Long> map1 = input.chars()
                .mapToObj(c -> (char) c)
                .collect(LinkedHashMap::new,
                        (map, ch) -> map.merge(ch, 1L, Long::sum), LinkedHashMap::putAll);

//        System.out.println("map: " + map1);

        System.out.println(map1.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().orElseThrow(() -> new RuntimeException("")));

        // 2. way
        String str = "ilovejavacoding";

        String res = Arrays.stream(str.split("")).filter(c -> str.indexOf(c) == str.lastIndexOf(c)).findFirst().get();
//        System.out.println(res);

        // 3. first non-repeating char from given string

        String given = "i love java coding"; // l
        var aLong1 = given.chars()
                .mapToObj(s -> Character.toLowerCase((char) s))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(value -> value.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();

        System.out.println("first non-repeating: " + aLong1);

    }
}
