package streams;

import java.util.Comparator;
import java.util.stream.IntStream;

public class RangeDemo {

    public static void main(String[] args) {
        IntStream intStream = IntStream.range(0, 10);

        var integer = intStream.boxed().max(Comparator.comparingDouble(value -> value)).get();
        System.out.println(integer);
    }
}
