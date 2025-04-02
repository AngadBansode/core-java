package threads;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureThenComposeExample {
    public static void main(String[] args) {
        // Step 1: Simulate fetching user ID
        CompletableFuture<Integer> userIdFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching user ID...");
            simulateDelay(1);
            return 101; // User ID
        });

        // Step 2: Fetch user details based on the user ID
        CompletableFuture<String> userDetailsFuture = userIdFuture.thenCompose(userId -> {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("Fetching user details for user ID: " + userId);
                simulateDelay(2);
                return "User Details for ID: " + userId;
            });
        });

        // Step 3: Handle the final result
        userDetailsFuture.thenAccept(userDetails -> {
            System.out.println("Result: " + userDetails);
        });

        // Prevent the main thread from exiting immediately
        simulateDelay(4);
    }

    // Helper method to simulate delay
    private static void simulateDelay(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
