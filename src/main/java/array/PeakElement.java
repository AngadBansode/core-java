package array;

import java.util.List;

//Find a peak element which is not smaller than its neighbours
/*Input: array[]= {5, 10, 20, 15}
        Output: 20
        Explanation: The element 20 has neighbors 10 and 15, both of them are less than 20.

        Input: array[] = {10, 20, 15, 2, 23, 90, 67}
        Output: 20 or 90*/
public class PeakElement {

    public static void main(String[] args) {
        int arr[] = {10, 20, 100, 35, 23, 90, 67};
        peakElements(arr);
    }

    private static void peakElements(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] < arr[i + 1] && arr[i + 2] < arr[i + 1]) {
                System.out.println(arr[i + 1]);
            }
        }
    }

}
