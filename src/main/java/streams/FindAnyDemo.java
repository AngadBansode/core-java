package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FindAnyDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        var any = list.stream()
                .filter(x -> x % 2 == 0)
                .map(delay -> {
                    delay();
                    return delay;
                })
                .findAny()
                .orElse(0);
        System.out.println(any);

        var result = list.stream()
                .filter(x -> x % 2 == 0)
                .findFirst()
                .orElse(0);
        System.out.println(result);
    }

    private static Object delay() {
        // generate random number range 100 to 2000
        var delay = new Random().nextInt(2000 - 100) + 100;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return delay;
    }
}