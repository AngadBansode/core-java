package streams;

import org.apache.commons.lang3.function.Functions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringAlphaStart {
    public static void main(String[] args) {
        String arr[] = {"apple", "banana", "apricot", "blueberry", "avocado"};

        var out = Arrays.stream(arr)
                .collect(Collectors.groupingBy(first -> first.charAt(0),
                        Collectors.mapping(String::toUpperCase,
                        Collectors.joining(";"))));

        System.out.println(out);

    }
}
