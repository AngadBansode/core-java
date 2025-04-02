/*

package threads;

import java.util.concurrent.*;

public class CustomThreadPoolExample {
    public static void main(String[] args) {
        // Define a thread pool with 2 core threads, 4 max threads, and a 30-second keep-alive time
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,                       // Core pool size
                4,                       // Maximum pool size
                30,                      // Keep-alive time
                0,//TimeUnit.SECONDS,        // Time unit for keep-alive time
                new LinkedBlockingQueue<>(2), // Task queue with a capacity of 2
                Executors.defaultThreadFactory(), // Default thread factory
                new ThreadPoolExecutor.CallerRunsPolicy() // Rejection policy
        );

        // Submit tasks to the thread pool
        for (int i = 1; i <= 10; i++) {
            final int taskNumber = i;
            threadPool.execute(() -> {
                System.out.println("Executing Task " + taskNumber + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulate task execution
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Shutdown the thread pool
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            threadPool.shutdownNow();
        }
    }
}

*/
