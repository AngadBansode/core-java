package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeekStreamDemo {
    public static void main(String[] args) {

        var stringList = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .toList();

        System.out.println(stringList);
    }
}
