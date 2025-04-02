package threads;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SynchornizationTest {

    public static void main(String[] args) {
        Emp e1 = new Emp(1, "Raj");
        Emp e2 = new Emp(2, "Pawan");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (e1) {
                    System.out.println(Thread.currentThread().getName());
                }
                synchronized (e2) {
                    System.out.println(Thread.currentThread().getName());
                }

            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (e1) {
                    System.out.println(Thread.currentThread().getName());
                }
                synchronized (e2) {
                    System.out.println(Thread.currentThread().getName());
                }

            }
        }, "t2");

        t1.start();
        t2.start();
    }
}

@Data
@AllArgsConstructor
class Emp {

    int id;
    String name;
}