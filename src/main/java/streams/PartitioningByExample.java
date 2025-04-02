package streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PartitioningByExample {

    public static void main(String[] args) {
        Map<Boolean, List<Long>> m = IntStream.range(1, 10)
                .mapToObj(Long::new)
                .collect(Collectors.partitioningBy(
                        i -> i % 2 == 0));
        System.out.println(m);


        Stream<String> s = Stream.of("Ace", "heart", "Club", "diamond");
        Map<Boolean, Long> m_1 = s.collect(Collectors.partitioningBy(
                x -> Character.isUpperCase(x.charAt(0)),
                Collectors.counting()));
        System.out.println(m_1);

      // 3
        Stream<Integer>
                sint = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using Collectors.counting() method
        // to count the number of elements in
        // the 2 partitions
        Map<Boolean, List<Integer>>
                map = sint.collect(
                Collectors.partitioningBy(
                        num -> (num > 3), Collectors.toList()));
        System.out.println(map );
    }
}
