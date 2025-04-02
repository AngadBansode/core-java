package threads;

import java.util.concurrent.locks.ReentrantLock;

public class IncrementTo100 {
    private static int counter = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new IncrementTask(), "Thread-1");
        Thread thread2 = new Thread(new IncrementTask(), "Thread-2");

        thread1.start();
        thread2.start();
    }

    static class IncrementTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (counter >= 100) {
                        break; // Exit if the counter has reached 100
                    }
                    counter++;
                    System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter);
                } finally {
                    lock.unlock(); // Ensure the lock is released even if an exception occurs
                }
            }
        }
    }
}
