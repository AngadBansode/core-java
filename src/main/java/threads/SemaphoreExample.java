package threads;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        // Create a semaphore with 2 permits
        Semaphore semaphore = new Semaphore(2);

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " attempting to acquire a permit...");
                semaphore.acquire(); // Acquire a permit
                System.out.println(Thread.currentThread().getName() + " acquired a permit!");

                // Simulate critical section
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " releasing a permit...");
                semaphore.release(); // Release the permit
            }
        };

        // Start multiple threads
//        for (int i = 0; i < 5; i++) {
            new Thread(task).start();
//        }
    }
}
