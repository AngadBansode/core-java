package threads;

import java.util.concurrent.*;

public class CompletableFutureExample {

    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future thread: " + Thread.currentThread().getName());
            // Simulate a long-running task
            sleep(15000);
            return 42;
        });

        future.thenAccept(result -> System.out.println("Result: " + result));
        var futureApply = future.thenApplyAsync(  no -> no + 42 );

        System.out.println("Doing something else while the task runs..." + Thread.currentThread().getName());
        System.out.println("Future Apply : " +  futureApply.join());
        sleep(3000); // Wait for the task to complete
        System.out.println("Join Future : "+ future.join() + ": " + Thread.currentThread().getName());
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
