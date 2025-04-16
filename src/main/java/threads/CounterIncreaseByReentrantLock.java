package threads;

import java.util.concurrent.locks.ReentrantLock;

public class CounterIncreaseByReentrantLock {

    static ReentrantLock lock = new ReentrantLock(true);
    private static int counter = 1;

    private static void counterIncrement() {

        while (counter <= 10) {
            lock.lock();
            if (counter % 2 == 0 && Thread.currentThread().getName().equals("T1")) {
                System.out.println("Thread " + Thread.currentThread().getName() + " : " + counter);
                counter++;
                //lock.unlock();
            }
            if (counter % 2 != 0 && Thread.currentThread().getName().equals("T2")) {
                System.out.println("Thread " + Thread.currentThread().getName() + " : " + counter);
                counter++;
                //lock.unlock();
            }
            lock.unlock();
        }
//        lock.unlock();

    }

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> counterIncrement(), "T1");
        Thread t2 = new Thread(() -> counterIncrement(), "T2");
        t1.start();
        t2.start();
    }


}
