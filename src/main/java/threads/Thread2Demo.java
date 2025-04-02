package threads;

import lombok.SneakyThrows;

public class Thread2Demo extends Thread {

    public static volatile int x = 0;
    public Object obj;

    public Thread2Demo(Object obj) {
        this.obj = obj;
    }

    @SneakyThrows
    public void run() {
        if (Thread.currentThread().getName().equals("T1")) {
            synchronized (obj) {
                for (int i = 0; i < 10; i++) {
                    x++;
                    System.out.println("T1 incremented x to: " + x);
                    obj.notifyAll(); // Notify other threads waiting on the lock
                    obj.wait(); // Wait for the next notification
                }
                obj.notifyAll(); // Notify other threads to exit waiting when done
            }
        } else if (Thread.currentThread().getName().equals("T2")) {
            synchronized (obj) {
                for (int i = 0; i < 10; i++) {
                    x++;
                    System.out.println("T2 incremented x to: " + x);
                    obj.notifyAll(); // Notify other threads waiting on the lock
                    obj.wait(); // Wait for the next notification
                }
                obj.notifyAll(); // Notify other threads to exit waiting when done
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished. Final x: " + x);
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread2Demo t1 = new Thread2Demo(lock);
        Thread2Demo t2 = new Thread2Demo(lock);
        t1.setName("T1");
        t2.setName("T2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
