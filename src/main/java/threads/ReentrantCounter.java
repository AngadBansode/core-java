package threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantCounter {

    private int count = 0;
    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
      ReentrantCounter counter = new ReentrantCounter();
      counter.increment();
        System.out.println(counter.getCount());
    }

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}
