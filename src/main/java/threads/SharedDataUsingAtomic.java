package threads;
// The java.util.concurrent.atomic package provides classes for atomic operations.
// Atomic variables handle concurrent updates without explicit synchronization.
import java.util.concurrent.atomic.AtomicInteger;

public class SharedDataUsingAtomic {

    public static void main(String[] args) throws InterruptedException {
        SharedData4 sharedData = new SharedData4();

        Thread t1 = new IncrementThread4(sharedData);
        Thread t2 = new IncrementThread4(sharedData);

        t1.start();
        t2.start();
//        Thread.sleep(1000);

        t1.join();
        t2.join();

        System.out.println("Final Counter Value: " + sharedData.counter.get());
    }
}

class SharedData4 {
    AtomicInteger counter = new AtomicInteger(0);
}

class IncrementThread4 extends Thread {
    private SharedData4 data;

    public IncrementThread4(SharedData4 data) {
        this.data = data;
    }
   @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            data.counter.incrementAndGet(); // Atomic operation
        }
    }
}

