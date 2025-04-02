package threads;

public class VolatileExample {
    private static  boolean flag = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
//            while (!flag) {
//                // Do something
//            }
            System.out.println(flag + ": Thread 1: Flag is now true");
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("Thread 2: Set flag to true");
        });

        thread1.start();
        thread2.start();

        System.out.println(flag);

    }
}