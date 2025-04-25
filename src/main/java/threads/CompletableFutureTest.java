package threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CompletableFutureTest {


    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Future-1 ThreadName: " + Thread.currentThread().getName());
//                    TimeUnit.SECONDS.sleep(2);
                Thread.sleep(2000);
                System.out.println("Task 1 completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },executor);

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Future-2 ThreadName: " + Thread.currentThread().getName());
                Thread.sleep(4000);
                System.out.println("Task 2 completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },executor);
         executor.shutdown();
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future2);

        // This line ensures the main thread waits until all tasks are complete
        var result = allOf.join();
//        System.out.println(result.toString()); // .NullPointerException
        System.out.println("Main Thread: " + Thread.currentThread().getName());
        System.out.println("All tasks completed");

    }
}
