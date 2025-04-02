package threads;
/* types of BlockingQueue
ArrayBlockingQueue
LinkedBlockingQueue
 */
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {
    private Queue<E> queue;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();
    private int max;

    public MyBlockingQueue(int size) {
        queue = new LinkedList<>();
        this.max = size;
    }

    public void put(E e) {
        lock.lock();

        try {
            while (queue.size() == max) {
                notFull.await();
            }
            queue.add(e);
            notEmpty.signalAll();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public E take() {
        lock.lock();
        E item = null;
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }
            item = queue.remove();
            notFull.signalAll();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return item;
    }

    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(10);
        Runnable producer = () -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("Produced:" + i);
                queue.put(i);
            }
        };

        Runnable consumer = () -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("Consumed:" + queue.take());
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}