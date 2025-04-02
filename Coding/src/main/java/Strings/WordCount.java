package Strings;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCount {

    public static void main(String[] args) {

        System.out.println("Hello, World!");

       int arr[] = {2, 6, 8, -2, 4};
        int result= findSmallestSum(arr);
        System.out.println("Smallest sum of Contigous sub array:"+ result);

    }
    public static int findSmallestSum(int[] arr) {
        int currentSum = arr[0];
        int smallestSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.min(arr[i], currentSum + arr[i]);
            smallestSum = Math.min(smallestSum, currentSum);
        }
        return smallestSum;

    }
}
