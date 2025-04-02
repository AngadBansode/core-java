package streams;

import java.util.Arrays;
import java.util.List;

public class MapReduce {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);

        List<String> words = Arrays.asList("corejava", "spring", "hibernate");

        //1. do sum
        var sum = numbers.stream().mapToInt(i -> i).sum();
        System.out.println(sum);
    }
}
