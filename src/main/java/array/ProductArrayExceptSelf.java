package array;

import java.util.Arrays;

// Product of Array Except Self
// ex.. Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
public class ProductArrayExceptSelf {

    public static void main(String[] args) {
//        int arr[] = {3, 2, 4, 8, 2 }; // 96
//        int arr[] = {0, 4, 0};
//        int arr[] = {1, 2, 3, 4};
//        int arr[] = {-1, 1, 0, -3, 3};
        int arr[] = {0, 0};
        int ans[] = findProductArray(arr);
        System.out.println(Arrays.toString(ans));

    }

    private static int[] findProductArray(int[] arr) {
        int[] ans = new int[arr.length];
        int totalProduct = 1;
        int cnt = 0;
        int zeroCnt = 0;
        boolean zeroCheck = false;
        for (int j : arr) {
            if (j != 0) {
                totalProduct *= j;
                cnt++;
            } else {
                zeroCheck = true;
                zeroCnt++;
            }
        }
        System.out.println(totalProduct);

        if (zeroCnt >= 2)
            totalProduct = 0;

        for (int i = 0; i < arr.length; i++) {
            if (zeroCheck) {
                if (arr[i] == 0 && cnt > 0) {
                    ans[i] = totalProduct;
                    break;
                }
            } else
                ans[i] = totalProduct / arr[i];
        }
        return ans;
    }
}
