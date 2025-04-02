package DS;

//Queue using array
public class QueueArray {
    static int arr[] = new int[1000];
    static int cnt= -1;
    static int size = 0;

    public static void main(String[] args) {

        queue(1);
        queue(2);
        queue(3);
        dqueue();
        queue(4);
        queue(5);
        dqueue();
        dqueue();
        dqueue();
        dqueue();
        dqueue();
        dqueue();
//        top();

    }

    private static void top() {
        System.out.println("top"+ arr[size-1]);
    }

    private static void dqueue() {
        cnt--;
        System.out.println(arr[size]);
        size++;
    }

    private static void queue(int i) {
         cnt++;
        arr[cnt] = i;
      
    }
}
