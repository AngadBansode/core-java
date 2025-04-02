package array;

import java.util.Arrays;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums){

        int n = nums.length;
        int[] result = new int[n];

        int[] leftSideProducts = new int[n];

        leftSideProducts[0] = 1;

        for(int i = 1; i < n ; i++){
            leftSideProducts[i] = leftSideProducts[i-1] * nums[i-1];
        }

        int rightSideProduct = 1;
        for (int i = n - 1; i >= 0; i--){
            result[i] = leftSideProducts[i] * rightSideProduct;
            rightSideProduct *= nums[i];
        }

        return result;
    }


    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        int arr [] = {1,2,3,4};
        int[] result = productExceptSelf(arr);
        System.out.println(Arrays.toString(result));


    }

}
