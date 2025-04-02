package threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureThenApplyDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        CompletableFuture<List<String>> completableFuture
                = CompletableFuture.supplyAsync(CompletableFutureThenApplyDemo::getMediaList);

        var listCompletableFuture = completableFuture.thenApply(list -> list.stream().map(String::toUpperCase).toList());


        System.out.println("join: " + listCompletableFuture.join());
        System.out.println("get: " + listCompletableFuture.get());

        // join the listCompletableFuture to future
        CompletableFuture<String> future = completableFuture
                .thenApply(s -> s + " World");

        System.out.println("Main thread");

        System.out.println(future.get());

    }

    private static List<String> getMediaList() {
//       return list with some data
        return Arrays.asList("Fig", "Media", "Energy");
    }

}