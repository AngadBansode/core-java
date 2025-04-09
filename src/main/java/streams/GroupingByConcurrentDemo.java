package streams;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GroupingByConcurrentDemo {

    public static void main(String[] args) {

        var evenNoOddNo = IntStream.rangeClosed(1, 100).boxed()
                .collect(Collectors.groupingByConcurrent(no -> no % 2 == 0, Collectors.counting()));
        System.out.println(evenNoOddNo);

        // check sequential vs parallelstream with groupingByConcurrent
        check();
//        optimized();
//        optimized2();
//          optimized3();
//        testWithForkJoinPool();

//        test();
    }

    private static void optimized3() {
        Long start = System.currentTimeMillis();
        // Use ConcurrentMap directly for reduced contention
        Map<Integer, Long> parallelGrouping = new ConcurrentHashMap<>();

        // Process in parallel, avoiding boxing and reducing contention
        IntStream.rangeClosed(1, 400_000_000)
                .parallel()
                .forEach(num -> parallelGrouping.merge(num % 3, 1L, Long::sum));

        Long end = System.currentTimeMillis();
        System.out.println("Time taken for parallel grouping: " + (end - start));
        // Print the result
        parallelGrouping.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    private static void test() {

        Long start = System.currentTimeMillis();
        Map<Integer, Long> sequentialGrouping = IntStream.rangeClosed(1, 400000000)
                .boxed()
                .collect(Collectors.groupingByConcurrent(
                        num -> num % 3,
                        Collectors.counting()
                ));
        Long end = System.currentTimeMillis();
        System.out.println("Time taken for sequential grouping: " + (end - start));
        System.out.println("Sequential Grouping: " + sequentialGrouping);

        // Parallel grouping using groupingByConcurrent
        Long start1 = System.currentTimeMillis();
        Map<Integer, Long> parallelGrouping = IntStream.rangeClosed(1, 400000000)
                .boxed()
                .parallel()
                .collect(Collectors.groupingByConcurrent(
                        num -> num % 3,
                        Collectors.counting()
                ));
        Long end1 = System.currentTimeMillis();
        System.out.println("Time taken for parallel grouping: " + (end1 - start1));
        System.out.println("Parallel Grouping: " + parallelGrouping);
    }


    private static void check() {
        // Sequential grouping
        // add timer to find the difference between seq and parallel
        Long start = System.nanoTime();
        long seCnt = IntStream.rangeClosed(1, 900_000_000)
                .boxed()
                .map(num -> num % 4)
                .count();

        Long end = System.nanoTime();
        System.out.println("Time taken for sequential grouping: " + (end - start));
        System.out.println("Sequential Grouping: " + seCnt);

        // Parallel grouping using groupingByConcurrent
        Long start1 = System.nanoTime();
        long cnt = IntStream.rangeClosed(1, 900_000_000)
                .boxed()
                .parallel()
                .map(num -> num % 4)
                .count();

        Long end1 = System.nanoTime();
        System.out.println("Time taken for parallel grouping: " + (end1 - start1));
        System.out.println("Parallel Grouping Cnt: " + cnt);
    }

    private static void optimized() {
        Long start1 = System.currentTimeMillis();
        long[] parallelGrouping = IntStream.rangeClosed(1, 400000000)
                .parallel()
                .mapToLong(num -> num % 3)
                .toArray();
        Long end1 = System.currentTimeMillis();
        System.out.println("Time taken for optimized parallel grouping: " + (end1 - start1));

    }

    private static void optimized2() {  //// Set the desired number of threads
        try (ForkJoinPool customPool = new ForkJoinPool(4)) {
            var re = customPool.submit(() -> {
                // Your parallel stream logic here
                Long start1 = System.currentTimeMillis();
                ConcurrentMap<Integer, Long> parallelGrouping = IntStream.rangeClosed(1, 400000000)
                        .boxed()
                        .parallel()
                        .collect(Collectors.groupingByConcurrent(
                                num -> num % 3,
                                Collectors.counting()
                        ));
                Long end1 = System.currentTimeMillis();
                System.out.println("Time taken for parallel grouping: " + (end1 - start1));
                System.out.println("Parallel Grouping: " + parallelGrouping);
            }).join();
            System.out.println("Result : " + re);
        }


    }

    private static void testWithForkJoinPool() {

        // Create a custom ForkJoinPool with 8 threads
        ForkJoinPool customPool = new ForkJoinPool(12);

        // Task to be executed in the custom pool
        Runnable task = () -> {
            Map<Integer, Long> parallelGrouping = new ConcurrentHashMap<>();
            Long start1 = System.currentTimeMillis();
            IntStream.rangeClosed(1, 400_000_000)
                    .parallel()
                    .forEach(num -> parallelGrouping.merge(num % 3, 1L, Long::sum));
            Long end1 = System.currentTimeMillis();
            System.out.println("Time taken for parallel grouping: " + (end1 - start1));
            parallelGrouping.forEach((key, value) -> System.out.println(key + " -> " + value));
        };

        // Submit the task to the custom ForkJoinPool
        customPool.submit(task).join();

        // Shutdown the pool
        customPool.shutdown();
    }


}
