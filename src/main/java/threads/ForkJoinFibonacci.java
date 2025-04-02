package threads;

import java.util.concurrent.RecursiveTask;

public class ForkJoinFibonacci extends RecursiveTask<Integer> {

    private final int n;

    public ForkJoinFibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }
        ForkJoinFibonacci f1 = new ForkJoinFibonacci(n - 1);
        f1.fork();
        ForkJoinFibonacci f2 = new ForkJoinFibonacci(n - 2);
        f2.fork();
        return f1.join() + f2.join();
    }

    public static void main(String[] args) {

        ForkJoinFibonacci f = new ForkJoinFibonacci(10);
        System.out.println(f.compute());
    }
}
