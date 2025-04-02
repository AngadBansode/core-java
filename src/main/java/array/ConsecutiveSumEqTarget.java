package array;

// not working
public class ConsecutiveSumEqTarget {

    public static void main(String[] args) {
//        int[] arr = {12, 2, 11, 4, 5, 33, 13, 2, 3, 4}; // 2 2 5 2 3 4
         int [] arr = {12,4,7,2,1,3,8,1,5,34,56,20,-7}; // target - 13
        int target = 13;

        consecutiveSum(arr, target);

    }

    private static void consecutiveSum(int[] arr, int target) {
        int sum = 0, start = 0;
        String str = "";
        for (int i = start; i < arr.length; i++) {
            if (start == arr.length - 1)
                break;
            sum = sum + arr[i];
            str = str + " " + arr[i];

            if (sum == target) {
                System.out.println(str);
            }

            if (i == arr.length - 1 || sum == target) {
                start++;
                sum = 0;
                str = "";
                i = start;
            }
        }
    }
}
