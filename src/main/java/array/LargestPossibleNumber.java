package array;

import java.util.Arrays;

public class LargestPossibleNumber {
    public static void main(String[] args) {
        int arr[] = {1, 34, 3, 98, 9, 76, 45, 4};

        // Convert the array to a list of strings
        String[] strArr = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // Sort the array with a custom comparator
        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));

        // Join the sorted array to form the largest number
        String result = String.join("", strArr);

        System.out.println("Largest number: " + result);
    }
}
