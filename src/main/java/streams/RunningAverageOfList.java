package streams;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RunningAverageOfList {
    public static void main(String[] args) {

        AtomicInteger count = new AtomicInteger(1);

        List<Integer> list = List.of(23,1,11,45,12);
        AtomicInteger sum = new AtomicInteger();
        var output = list.stream()
                .map(ele -> {
                    sum.set(ele + sum.get());
                    return sum.get() / count.getAndIncrement();
                })
                .peek(System.out::println)
                .toList();
        System.out.println(output);
    }
}
