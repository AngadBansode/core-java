package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAll {

    public static void main(String[] args) {

        // Range
//        IntStream.range(1, 10).forEach(System.out::println);// 1...9
//        IntStream.rangeClosed(1, 10).forEach(System.out::println);// 1...10

        // Stream
        Stream.of("a", "b", "c").forEach(System.out::println);

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // sum of integerList
        long sum = integerList.stream().mapToInt(Integer::intValue).sum();
        // print sum
        System.out.println(sum);

        checkIfElse();

    }

    private static void checkIfElse() {

        for (int i = 0; i < 6; i++) {

            if (i == 3 || i == 5) {
                System.out.println(i);
                System.exit(-1);
            } else {
                System.out.println("else: " + i);
            }
            System.out.println("Everytime....");
        }
    }
}
