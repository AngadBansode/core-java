package threads;

import java.util.concurrent.locks.ReentrantLock;
// print odd & even numbers by each thread t1,t2 respectively
public class ReentrantLockDemo {

    static ReentrantLock lock = new ReentrantLock();

    private void accessResource() {
        System.out.println("Accessing resource...");
        lock.lock();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0 && Thread.currentThread().getName().equals("T1")) {
                System.out.println("Thread_Name: " + Thread.currentThread().getName() + ": " + i);
            }
            if (i % 2 != 0 && Thread.currentThread().getName().equals("T2")) {
                System.out.println("Thread_Name: " + Thread.currentThread().getName() + ": " + i);
            }
        }
        System.out.println("Lock count: " + lock.getHoldCount());
        lock.unlock();

        System.out.println("Lock count after release: " + lock.getHoldCount());
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> new ReentrantLockDemo().accessResource());
        t1.setName("T1");
        Thread t2 = new Thread(() -> new ReentrantLockDemo().accessResource());
        t2.setName("T2");
        t2.start();
        t1.start();


    }
}
