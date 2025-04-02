package threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TyreChangeTask {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Waiting for tyre to get changed");
        CountDownLatch latch = new CountDownLatch(4);
        WheelBalancing balancing = new WheelBalancing(latch);
        Thread thread1 = new Thread(balancing);
        Thread thread2 = new Thread(balancing);
        Thread thread3 = new Thread(balancing);
        Thread thread4 = new Thread(balancing);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
         latch.await();
        System.out.println("Done the balancing wheel...!");
    }
}

class WheelBalancing implements Runnable {
    CountDownLatch latch;

    WheelBalancing(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("started balancing wheel...");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Tyre balanced");
        latch.countDown();
    }

}