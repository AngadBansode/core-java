package threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducerConsumer {

    public static void main(String[] args) {

        BlockingQueue<Integer> taskQ = new ArrayBlockingQueue<>(10);

        Runnable producer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {

                        var val = new Random().nextInt(100);
                        System.out.println("producer : " + val);
                        taskQ.put(val);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        new Thread(producer).start();
        // consumer ---

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int val = taskQ.take();
                        System.out.println("consumer: " + val);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        new Thread(consumer).start();
    }
}
