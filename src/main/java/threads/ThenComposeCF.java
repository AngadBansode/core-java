package threads;

import java.util.concurrent.CompletableFuture;

public class ThenComposeCF {

    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World!"));

        future.thenAccept(System.out::println); // Outputs: Hello World!
    }

}
