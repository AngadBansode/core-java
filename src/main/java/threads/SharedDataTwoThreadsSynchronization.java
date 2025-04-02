package threads;
//multiple threads can communicate and share data using shared variables or objects
/// there are multiple ways
 //1. synchronization, 2. wait & notify, 3. Lock, 4. AtomicInteger, 5. ConcurrentMap, 6.Volatile
public class SharedDataTwoThreadsSynchronization {

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

class SharedData {
    int counter = 0;
}

class IncrementThread extends Thread {
    private final SharedData3 data;

    public IncrementThread(SharedData3 data) {
        this.data = data;
    }
   @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (data) { // Synchronize to ensure thread safety
                data.counter++;
            }
        }
    }
}