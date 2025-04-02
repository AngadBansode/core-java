package code;

public class MissingNumber
{
    static int missingNumber(int[] arr) {
        int n = arr.length + 1;

        // Calculate the sum of array elements
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += arr[i];
        }
        // 1, 2, 3, 5  = 11

        // Calculate the expected sum
        int expectedSum = (n * (n + 1)) / 2; // 5*(5+1) / 2 = 30/2 = 15

        // Return the missing number
        return expectedSum - sum;
         // 15-11 = 4
    }

    public static void main(String[] args) {
        int[] arr = { 5, 1, 4, 3,6 };
        System.out.println("length: " + arr.length);
        System.out.println(missingNumber(arr));
    }
}

