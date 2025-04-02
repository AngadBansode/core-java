package streams;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class InfiniteStreams {
    public static void main(String[] args) {

        // generate the random infinite streams
//    Stream.generate(Math::random).forEach(System.out::println);
        UnaryOperator<Integer> unaryOperator = (cal) -> (1 + (int) (Math.random() * 100));
        System.out.println("Unary: " + unaryOperator.apply(1));


//      Stream.iterate(1, n -> n + 1).forEach(System.out::println);

      //
        //Stream<Double> randomStream =
        Stream.generate(Math::random).forEach(System.out::println); // Infinite random numbers
        //Stream<Double> finiteRandomStream = randomStream.limit(5);   // Limit to 5 elements
        //finiteRandomStream.forEach(System.out::println);
    }


}
