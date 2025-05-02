package streams;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLazy {

    public static void main(String[] args) {

        var evenElement = Stream.of(1, 2, 3, 4, 5, 6, 7, 8).filter(even -> even % 2 == 0)
                .onClose(() -> System.out.println("value"));

//        evenElement.forEach(System.out::println);

        Stream<String> stream = Stream.of("A", "B", "C")
                .onClose(() -> System.out.println("Stream is being closed"));
        stream.forEach(System.out::println);

        String str = "hhoous"; // u

        var first =  str.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(values -> values.getValue() == 1)
                .findFirst().get();
        System.out.println("First: " + first);
    }
}
