package threads;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> future = executor.submit(() -> {
            // Simulate a long-running task
            System.out.println("Future thread: " + Thread.currentThread().getName());//pool-1-thread-1
            Thread.sleep(12000);

            return 42;
        });

        try {
            System.out.println("Doing something else while the task runs..." + Thread.currentThread().getName());// main
            // Wait for the result
            Integer result = future.get();
            System.out.println("Result: " + result + ": " + Thread.currentThread().getName()); // main
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
