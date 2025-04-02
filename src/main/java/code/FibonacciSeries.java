package code;

public class FibonacciSeries {

    public static void main(String[] args) {

        printFibonacciSeries(10);
    }

    public static void printFibonacciSeries(int n) {
        int pre = 1, sum;
        int pre_sum = 0;
       int total_sum = 0;
       while (n > 0) {

            sum = pre + pre_sum;
            pre_sum = pre;
            pre = sum;
            n--;
            total_sum += sum;
            System.out.println(sum);

        }
        System.out.println("TotalSum: " + total_sum);
    }
}
