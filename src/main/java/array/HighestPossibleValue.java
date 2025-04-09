package array;

import java.util.*;

public class HighestPossibleValue {
    public static void main(String[] args) {
        int arr[] = {1, 34, 3, 98, 9, 76, 45, 4};

        String s1= "21";
        String s2= "12";
        System.out.println( s1.compareTo(s2));

        System.out.println("Highest possible value: " + formHighestValue(arr));
    }

    public static String formHighestValue(int[] arr) {
        // Convert the integer array to a String array
        String[] strArr = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // Sort the array with a custom comparator
        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));
                   //       (1,2) -> (21).compareTo(12)
        // If the highest number is "0", the result is "0" (to handle cases like [0, 0])
        if (strArr[0].equals("0")) {
            return "0";
        }

        // Join the sorted array to form the highest value
        return String.join("", strArr);
    }
}
