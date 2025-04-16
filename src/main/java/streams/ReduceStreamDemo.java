package streams;

import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class ReduceStreamDemo {

    public static void main(String[] args) {

        int reduce = IntStream.of(1, 2, 3, 4, 5)
                .reduce(0, Integer::sum);
        System.out.println(reduce);

        var reduce1 = IntStream.of(1, 2, 3, 4, 5)
                .reduce(11, (left, ri) -> left);
        System.out.println(reduce1);

    }
}
