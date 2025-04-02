package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamNewMethods {

    public static void main(String[] args) {

        //1. Stream.ofNullable() -- JDK 9

        List<String> names = Arrays.asList("Angad", "Raju", null, "Ravi", null);

        var streams = names.stream().flatMap(Stream::ofNullable).toList();
        System.out.println(streams);

        // 2. stream.teeing()

        List<Integer> numbs = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        var minMaxMap = numbs.stream().collect(Collectors.teeing(Collectors.maxBy(Integer::compareTo),
                Collectors.minBy(Integer::compareTo),
                (e1, e2) -> Map.of("max", e1.get(), "min", e2.get())));

        System.out.println(minMaxMap);

        //3 stream.concat
        Stream<Integer> integerStream1 = Stream.of(1, 2, 3);
        Stream<Integer> integerStream2 = Stream.of(6, 5, 4);
        Stream<Integer> stream = Stream.concat(integerStream1, integerStream2);
        long sum = stream.mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        // 4. Collectors.partitionBy

        var collect = numbs.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println("Even num : " + collect.get(Boolean.TRUE));
        System.out.println("Odd num : " + collect.get(Boolean.FALSE));

        // 5. IntStream.range(1, 20)
        var integerList1 = IntStream.range(1, 20).boxed().toList();
        System.out.println(integerList1);
        var integerList2 = IntStream.rangeClosed(1, 20).boxed().toList();
        System.out.println(integerList2);

    }
}
