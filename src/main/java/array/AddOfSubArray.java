package array;

/*Input: arr[] = {1, 2, 3}
        Output: 20
        Explanation: {1} + {2} + {3} + {2 + 3} + {1 + 2} + {1 + 2 + 3} = 20

        Input: arr[] = {1, 2, 3, 4}
        Output: 50*/
public class AddOfSubArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3,4};
        int totalSum = 0;
        for (int j : arr) {
            totalSum = totalSum + j;
        }
        totalSum += totalSum;
        for (int j = 0; j < arr.length - 1; j++) {
            totalSum += arr[j] + arr[j + 1];
        }
        System.out.println(totalSum);
    }
}
