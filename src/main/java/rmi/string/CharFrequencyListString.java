package rmi.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CharFrequencyListString {

    public static void main(String[] args) {
        List<String> stringList = List.of("Hello", "Bye", "Belcome");

       var result = stringList.stream()
               .flatMap(chars -> Arrays.stream(chars.split("")))
               .peek(System.out::println)
                .collect(Collectors.groupingBy(chars ->chars,
                        Collectors.counting()));
        System.out.println(result);

    }
}
