package threads;
///The ReentrantLock class provides more advanced locking mechanisms than synchronized.
// The ReentrantLock allows explicit locking and unlocking with finer control.

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedDataUsingLock {
    public static void main(String[] args) throws InterruptedException {
        SharedData3 sharedData = new SharedData3();

        Thread t1 = new IncrementThread2(sharedData);
        Thread t2 = new IncrementThread2(sharedData);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Counter Value: " + sharedData.counter);
    }

}

class SharedData3 {
    int counter = 0;
    Lock lock = new ReentrantLock();
}

class IncrementThread2 extends Thread {
    private SharedData3 data;

    public IncrementThread2(SharedData3 data) {
        this.data = data;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            data.lock.lock(); // Acquire lock
            try {
                data.counter++;
            } finally {
                data.lock.unlock(); // Release lock
            }
        }
    }
}
