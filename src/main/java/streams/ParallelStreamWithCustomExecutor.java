package streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelStreamWithCustomExecutor {
    public static void main(String[] args) {
        // Create a list of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Create a custom ForkJoinPool with desired parallelism level
        ForkJoinPool customThreadPool = new ForkJoinPool(4); // 4 threads in this example

        try {
            // Use the custom thread pool for the parallel stream
            customThreadPool.submit(() -> {
                numbers.parallelStream()
                        .map(ParallelStreamWithCustomExecutor::process)
                        .forEachOrdered(System.out::println);
            }).get(); // Wait for completion
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            customThreadPool.shutdown(); // Shutdown the pool
        }
    }

    // Simulate some processing for each element
    private static Integer process(Integer number) {
        System.out.println(Thread.currentThread().getName() + " processing " + number);
        return number * 2;
    }
}
