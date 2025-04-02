package threads;
//The volatile keyword ensures that changes to a variable are immediately visible to all threads,
//      preventing caching issues.

public class SharedDataUsingVolatile {

    public static void main(String[] args) throws InterruptedException {
        SharedData2 sharedData = new SharedData2();

        Thread t = new WorkerThread(sharedData);
        t.start();
        System.out.println("Thread name before sleep : " + Thread.currentThread().getName());
        Thread.sleep(3000); // Simulate some delay
        sharedData.flag = true; // Update the shared variable

        System.out.println("Thread name: " + Thread.currentThread().getName());
        t.join();
        System.out.println("Thread name: " + t.getName());

    }


}


class SharedData2 {
    volatile boolean flag = false;
}

class WorkerThread extends Thread {
    private SharedData2 data;

    public WorkerThread(SharedData2 data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (!data.flag) {
            // Waiting for the flag to change
        }
        System.out.println("Flag is true, exiting loop.");
    }
}