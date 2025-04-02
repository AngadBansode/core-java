package DS;

// implement Q using array
public class QueueUsingArray {
    public static void main(String[] args) {

        Queue q = new Queue();
        q.Queue(10);
        q.Queue(20);
        q.Queue(30);

        System.out.println("size: " + q.size());
        System.out.println("top: " + q.top());
        System.out.println("Deque : " + q.Deque());
        System.out.println("after Deque");
        System.out.println("size: " + q.size());
        System.out.println("top: " + q.top());
        System.out.println("Add: ");
        q.Queue(40);
        System.out.println("size: " + q.size());
        System.out.println("top: " + q.top());
        System.out.println("last: " + q.last());
        q.Queue(50);
        q.Queue(60);
        q.Deque();
        System.out.println("print Q" +"\t");
        q.print();
        q.Queue(70);
        System.out.println("-----------------------------");
        System.out.println("size: " + q.size());
        System.out.println("top: " + q.top());
        System.out.println("last: " + q.last());
        q.print();


    }
}

class Queue {
    int size = 1000;
    int arr[] = new int[size];
    int start = -1;
    int initial = -1;

    public void Queue(int i) {
        start++;
        arr[start] = i;
    }

    public int Deque() {
        initial++;
        int val = arr[initial];
        return val;
    }

    public int top() {
        return arr[initial + 1];
    }

    public int size() {
        if (initial == -1)
            return start + 1;
        else
            return (start - initial);
    }

    // last
    public int last() {
        return arr[start];
    }
    public void print(){
        for(int i = initial+1;i<=start; i++){
            System.out.print( arr[i]+" ");
        }
    }
}
