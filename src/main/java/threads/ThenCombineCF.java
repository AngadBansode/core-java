package threads;

import java.util.concurrent.CompletableFuture;

public class ThenCombineCF {

    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> combinedFuture = future1.thenCombine(future2, (num1, num2) -> num1 + num2);

        combinedFuture.thenAccept(result -> System.out.println("Result: " + result)); // Outputs: Result: 30
    }
}
