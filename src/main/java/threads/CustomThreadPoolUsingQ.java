/*
package threads;

import java.util.concurrent.*;

public class CustomThreadPoolUsingQ {

    public static void main(String[] args) {
        // Step 1: Define core and maximum pool size
        int corePoolSize = 4;
        int maximumPoolSize = 8;
        long keepAliveTime = 10; // seconds

        // Step 2: Define the task queue
        BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<>(50);

        // Step 3: Define the thread factory
        ThreadFactory threadFactory = new ThreadFactory() {
            private int counter = 0;

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("CustomThread-" + counter++);
                return thread;
            }
        };

        // Step 4: Define the rejection handler
        RejectedExecutionHandler rejectionHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("Task rejected: " + r.toString());
            }
        };

        // Step 5: Create the ThreadPoolExecutor
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                taskQueue,
                threadFactory,
                rejectionHandler
        );

        // Step 6: Submit tasks to the thread pool
        for (int i = 0; i < 20; i++) {
            threadPool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is executing a task.");
                try {
                    Thread.sleep(2000); // Simulate task execution
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Step 7: Shutdown the thread pool
        threadPool.shutdown();
    }
}
*/
