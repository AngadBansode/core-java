package threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EvenOddUsingES {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);

        IntStream.rangeClosed(1, 10).forEach(num -> {
            CompletableFuture<Integer> evenFuture = CompletableFuture.completedFuture(num)
                    .thenApplyAsync(i -> {
                        if (i % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() + ":  " + i);
                        }
                        return num;
                    }, es);
                  evenFuture.join();

            CompletableFuture<Integer> oddFuture = CompletableFuture.completedFuture(num)
                    .thenApplyAsync(i -> {
                        if (i % 2 != 0) {
                            System.out.println(Thread.currentThread().getName() + ":  " + i);
                        }
                        return num;
                    }, es);
                  oddFuture.join();
            CompletableFuture.allOf(evenFuture, oddFuture).join();


        });
        es.shutdown();
    }
}