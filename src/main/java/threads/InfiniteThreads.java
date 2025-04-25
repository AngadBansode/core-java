package threads;

import java.util.DoubleSummaryStatistics;

// Dont run
public class InfiniteThreads {

    public static void main(String[] args) {

        System.out.println("Main thread: " + Thread.currentThread().getName());
        System.out.println("Active count before: " + Thread.activeCount()); // 2
        Thread.getAllStackTraces().entrySet()
                .stream().forEach((v) -> System.out.println("Key: " + v.getKey() + ", Val: " + v.getValue()));
        int count = 0;
        try {
            while (true) {
                Thread thread = new Thread(() -> {
                    try {
                        Thread.sleep(1_00_000);
                    } catch (Exception e) {

                    }
                });
                thread.start();
                count++;
                if (Thread.activeCount() == 1500) {
                    System.out.println("Active count in condition: " + Thread.activeCount());
                     System.exit(-1);
                }
                System.out.println("Active count: " + count);
               // System.out.println(thread);
            }
        } catch (OutOfMemoryError error) {
            System.out.println("Max threads before create: " + count);
            error.printStackTrace();
        }
    }
}
