package threads;

import java.util.concurrent.CountDownLatch;


public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdt = new CountDownLatch(4);
        Worker worker = new Worker(cdt);
        worker.countDown();
        cdt.await();
        System.out.println("Main thread...");
    }
}

class Worker{
    CountDownLatch latch;
    Worker(CountDownLatch latch){

        this.latch = latch;
    }

    public void countDown() throws InterruptedException {

        for(int i=1; i<=4;i++){
            System.out.println("current count: " + latch.getCount());
//            TimeUnit.SECONDS.sleep(2);
            Thread.sleep(2000);
            latch.countDown();
        }
        System.out.println("Done count");
    }

}
