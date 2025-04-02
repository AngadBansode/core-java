package streams;

import java.util.*;
import java.util.stream.IntStream;

public class ParallelStreamReduce {

    public static void main(String[] args) {

        // reduce() method is used to combine elements of a stream in parallel
  List<Integer> numbers = Arrays.asList(1, 2, 3, 4); //
        int sum = numbers.stream().parallel()
                .reduce(2, Integer::sum);

        System.out.println(sum);

        System.out.println(numbers.parallelStream().isParallel());
        System.out.println(numbers.stream().parallel().isParallel());

      int sum1 =  IntStream.rangeClosed(1,10)
                .parallel()
                .reduce(1,Integer::sum);
        System.out.println(sum1); // 65
    }
}
