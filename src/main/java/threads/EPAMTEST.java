package threads;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EPAMTEST {

    public static void main(String[] args) {
        List<String> strList = List.of("apple", "banana", "apple", "cherry","banana", "apple");

        var result = strList.parallelStream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        System.out.println(result);
    }

}
