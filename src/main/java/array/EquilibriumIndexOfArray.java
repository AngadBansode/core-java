package array;

public class EquilibriumIndexOfArray {
    public static void main(String[] args) {

//        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        int arr [] = {1,2,5,6};
        System.out.println(equilibriumIndex(arr));

    }

    private static int equilibriumIndex(int[] arr) {
        int totalSum = 0;
        int leftSum = arr[0];
        int rightSum;
        for (int j : arr) {
            totalSum = totalSum + j;
        }
        for (int i = 1; i < arr.length; i++) {
            rightSum = totalSum - leftSum - arr[i];
            if (rightSum == leftSum)
                return i;
            leftSum = leftSum + arr[i];
        }
        return -1;
    }

}
