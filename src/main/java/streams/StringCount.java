package streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCount {
    public static void main(String[] args) {
        String str = "aabbbccd";
        var characterStream = str.chars().mapToObj(c -> (char) c);

        var collect = characterStream
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.println(collect);
    }
}
