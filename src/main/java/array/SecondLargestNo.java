package array;

public class SecondLargestNo {

    public static int second(int[] a) {
        int high = 0;
        int sec = 0;
        for (int i = 0; i < a.length; i++) {
            if (high < a[i]) {
                sec = high;
                high = a[i];
            } else if (sec < a[i]) {
                sec = a[i];
            }
        }
        System.out.println("Highest :" +  high);
        return sec;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,0,8,6};
        if(arr.length ==1){
            System.out.println(0);
            return;
        }
        int result = second(arr);
        System.out.println(result);
    }
}
