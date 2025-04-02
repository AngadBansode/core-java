package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.apache.commons.lang3.ArrayUtils.contains;

public class _3rdAnd4thHighestNoSum {

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 1, 2, 8, 9, 10, 3, 7};

        List<Integer> thirdHighest = find3rdHighest(arr);
        System.out.println(thirdHighest.get(0) + thirdHighest.get(1));//15
        findNthAndNextHighestNumber(arr, 3);
    }

    private static void findNthAndNextHighestNumber(int[] arr, int N) {

        int[] largestElements = new int[N + 1];
        Arrays.fill(largestElements, Integer.MIN_VALUE);
        for (int i = 0; i < N + 1; i++) {
            int largest = Integer.MIN_VALUE;
            for (int k : arr) {
                if (k > largest && !contains(largestElements, k)) {
                    largest = k;
                }
            }
            largestElements[i] = largest;
        }
        System.out.println("Largest elements are : " + Arrays.toString(largestElements));
        System.out.println(largestElements[N] + largestElements[N - 1]);//15
    }

    private static List<Integer> find3rdHighest(int[] arr) {

        return Arrays.stream(arr).boxed()
                .sorted(Collections.reverseOrder())
                .skip(2)
                .limit(2)
                .toList();

    }
}
