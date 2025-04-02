package array;

import java.util.Arrays;
/* a =a+b;
 b=a-b;
 a = a-b*/

public class SortArrayUsingSingle {

    public static void main(String[] args) {
//        int[] arr = {12, 3, 4, 56, 9, 13, 23, 10};
          int [] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sortInAsc(arr);
    }

    private static void sortInAsc(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] > arr[i + 1]) {

                arr[i] = arr[i] + arr[i + 1];
                arr[i + 1] = arr[i] - arr[i + 1];
                arr[i] = arr[i] - arr[i + 1];
                i = -1;

            }

        }
        System.out.println(Arrays.toString(arr));
    }
}
