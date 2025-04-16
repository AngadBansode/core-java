package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectingAndThenDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5,1);

        var result = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.collectingAndThen(
                        Collectors.summingInt(Integer::intValue),
                        sum -> "Sum is: " + sum
                )));

        System.out.println(result); // Output: Sum is: 15
    }
}
