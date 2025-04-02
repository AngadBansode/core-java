package streams;

import fuctional.MyFunctionalInterface;

import java.util.stream.Stream;

public class ConcatStreamDemo {
    public static void main(String[] args) {

        // concat two streams
        var stream1 = Stream.of(1, 2, 3);
        var stream2 = Stream.of(4, 5, 6);
        var concatStream = Stream.concat(stream1, stream2);
        concatStream.forEach(System.out::println);


    }
}
