package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartitioingByDemo {

    public static void main(String[] args) {
        String message = "Hi there, how are you, I am fine, what about you, ok";

        var collect = Arrays.stream(message.split(","))
                .filter(Objects::nonNull)
                .collect(Collectors.partitioningBy(result -> result.length() > 5));
        System.out.println(collect);

      List<Integer> values  = List.of(1,2,3,4,5,6);

        var collect1 = values.stream().collect(Collectors.partitioningBy(ele -> ele > 5));
        System.out.println(collect1);
    }
}
