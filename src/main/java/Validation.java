import java.util.*;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Validation {

    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Hello");
        completableFuture.thenApplyAsync(s -> s + " World").thenAccept(System.out::println);
        var join = completableFuture.join();
        System.out.println(join);

        int[] arr = {1, 2, 4, 6, 3, 2, 1};// find the duplicates
        Set<Integer> unique = new HashSet<>();

        Arrays.stream(arr).boxed()
                .filter(duplicates -> !unique.add(duplicates))
                .forEach(System.out::println);

        Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(duplicates -> duplicates.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

        List<Long> longs = Arrays.asList(12L, 6L, 7L, 34L, 8L, 99L);
        double totalLongs = sum(longs);
        System.out.println("Total Longs: " + totalLongs);
        List<Integer> doubles = Arrays.asList(12, 6, 7, 34, 8, 99);
        double totalDoubles = sum(doubles);
        System.out.println("Total Int: " + totalDoubles);
    }

    public static double sum(List<? extends Number> numbers) {
        return numbers.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
    }
}

