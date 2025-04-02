package streams;

import java.util.Arrays;
import java.util.List;

public class DemoParallel {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4); //
        int sum = numbers.stream().parallel()
                .reduce(2, Integer::sum);

        System.out.println(sum);
    }
}
