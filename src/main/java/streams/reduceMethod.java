package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class reduceMethod {

    public static void main(String[] args) {
        // 1. Strings
        var reduce = Stream.of("B", "C", "D")
                .reduce("A", (f, n) -> f +","+ n);
//        System.out.println(reduce); // A,B,C,D

    //2. int vals

        var sum = Stream.of(1, 2, 3, 4, 5, 6)
                .reduce((a, b) -> a + b)
                .orElse(0);
//        System.out.println(sum);

        // sum with identity
        var list = List.of(1,2,3);
       var val =   list.stream()
                  .reduce(11, Integer::sum);
        System.out.println(val);

    }

}
