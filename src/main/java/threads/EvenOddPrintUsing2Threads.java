package threads;

public class EvenOddPrintUsing2Threads implements Runnable {

    static int counter = 1;
    private Object object;

    public EvenOddPrintUsing2Threads(Object obj) {
        this.object = obj;
    }

    @Override
    public void run() {
        while (counter <= 10) {

            if (counter % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + " : " + counter);
                    counter++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

            }

            if (counter % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + " : " + counter);
                    counter++;
                    object.notify();
                }
            }

        }
    }

    public static void main(String[] args) {
        Object obj = new Object();
        Runnable even = new EvenOddPrintUsing2Threads(obj);
        Runnable odd = new EvenOddPrintUsing2Threads(obj);
        Thread t1 = new Thread(even, "even");
        Thread t2 = new Thread(odd, "odd");
        t1.start();
        t2.start();

    }


}
