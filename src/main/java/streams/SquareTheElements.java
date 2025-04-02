package streams;

import java.util.Arrays;

public class SquareTheElements {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 2};

        Arrays.stream(numbers)
                .boxed()
                .mapToInt(ele -> ele*ele)
                .peek(System.out::println)
                .forEach(System.out::println);
    }
}
