package code;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

// add == 12345 -- 1+2+3+4+5 == 15
public class NumberAddition {

    public static void main(String[] args) {
        int no = 12345;
        Integer arr[] = {51, 32, 43};
        AtomicInteger sum = new AtomicInteger();

        var integerList = Arrays.stream(arr).map(number -> {
            sum.set(0);
            while (number > 0) {
                sum.addAndGet(number % 10);
                number /= 10;
            }
            return sum.get();
        }).toList();


        System.out.println(integerList);

    }
}
