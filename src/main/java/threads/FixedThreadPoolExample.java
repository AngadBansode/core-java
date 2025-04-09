package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 1; i <= 10; i++) {
            int task = i;
            executor.submit(() -> {
                System.out.println("Executing Task " + task + " by " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}
