package streams;

import java.util.stream.Stream;

public class StreamWithoutTerminal {

    public static void main(String[] args) {
     var result =     Stream.of(1, 2, 3, 4, 5)
                .peek((e) -> System.out.println("ele: " + e))
                .map(i -> {
                    System.out.println("Ele: " + i*2);
                    return i * 2;

                })
                .count();
        System.out.println(result);// 5


    }
}











/*
 *  Stream.of("one", "two", "three", "four")
 *    .filter(e -> e.length() > 3)
 *     .peek(e -> System.out.println("Filtered value: " + e))
 *    .map(String::toUpperCase)
 *      .peek(e -> System.out.println("Mapped value: " + e))
 *     .collect(Collectors.toList());
 * */