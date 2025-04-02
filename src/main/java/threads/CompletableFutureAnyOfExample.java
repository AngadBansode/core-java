package threads;

import java.util.concurrent.CompletableFuture;


public class CompletableFutureAnyOfExample {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result from Future1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result from Future2";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result from Future3";
        });

        // Use anyOf to wait for the first completion
//        CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2, future3);

        CompletableFuture<Void> anyOfFuture = CompletableFuture.allOf(future1, future2, future3);
        // Attach a callback to process the result
        anyOfFuture.thenAccept(result -> {
            System.out.println("First completed future result: " + result);
        });

        // Prevent the main thread from exiting immediately
//        try {
//            sleep(4);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("Main thread: " + Thread.currentThread().getThreadGroup());
    }

    private static void sleep(long millis) throws InterruptedException {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
