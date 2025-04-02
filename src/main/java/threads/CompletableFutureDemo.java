package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        String str = completableFuture.get();
        System.out.println(str);
        CompletableFuture<String> future = completableFuture
                .thenApply(s -> s + " World");

        System.out.println("Main thread");

        System.out.println("Get: " + future.get());

        System.out.println("---------------------------------------------------------------------------");

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> System.out.println("Hello World"));

        // Wait for the task to complete
        voidCompletableFuture.join();


      // print hello using Callable and ExecutorService

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callableTask = () -> "Hello World from Callable";


        Future<String> stringFuture = executorService.submit(callableTask);

        // Get the result of the callable task
        System.out.println(stringFuture.get());

        // Shutdown the executor service
        executorService.shutdown();
    }

}
