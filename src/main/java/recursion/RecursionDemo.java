package recursion;

public class RecursionDemo {
static int cnt = 0;
    public static void main(String[] args) {

        printHello();

    }

    private static void printHello() {
        if(cnt>=3)
            return;
        cnt++;
        System.out.println("hello - " + cnt);
        printHello();
    }
}
