package threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureVsCFTest {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(FutureVsCFTest::getWinnerName, executor);
       executor.shutdown();
        if(executor.isTerminated()) // false
            System.out.println("shutdown executor....");
        CompletableFuture<String> fullName = completableFuture.thenApply(firstName -> firstName + "Pawar");
        System.out.println("WinnerName: " + fullName.get());
        System.out.println("Main thread: " + Thread.currentThread().getName());

        if(executor.isTerminated()) // true
            System.out.println("shutdown executor....");

     /*   Future<String> future = executor.submit(FutureVsCFTest::getWinnerName);
        System.out.println("WinnerName:  - ThreadName: " + Thread.currentThread().getName());
        String winnerName = future.get();// main block
        System.out.println("WinnerName: " + winnerName + " - ThreadName: " + Thread.currentThread().getName());
        System.out.println("Main thread: " + Thread.currentThread().getName());*/
    }

    private static String getWinnerName() {
        System.out.println("In getWinnerName()");
        try {
            Thread.sleep(5000);// 5 sec
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Rohit";
    }
}
