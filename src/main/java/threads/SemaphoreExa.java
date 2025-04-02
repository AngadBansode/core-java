package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExa {

    public static void main(String[] args)  {

        Semaphore semaphore = new Semaphore(1);
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Runnable task = () -> {
            boolean permit = false;
            try {
                 semaphore.acquire();
                if (permit) {
                    System.out.println("Semaphore acquired...!!");
                   sleep(2_000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("Finally...");

                    System.out.println("Releasing...");
                    semaphore.release();
                    System.out.println("Released...");

            }
         };
         executorService.execute(task);
        System.out.println("Main thread....!!!");
        executorService.shutdown();
    }

    private static void sleep(int i) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
