package array;

import java.util.Arrays;

// find the duplicates in an array in-place
public class DuplicatesInPlace {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 4, 4, 5};

        int nums = findDuplicates(arr);
        for (int i = 0; i < nums; i++) {
            System.out.println(arr[i]);
        }
    }

    private static int findDuplicates(int[] arr) {

        int n = arr.length - 1;
        int max = Arrays.stream(arr).max().orElse(0);
        int uniqueCount = 0;
        boolean[] visited = new boolean[max + 1];
        for (int i = 0; i <= n; i++) {
            if (!visited[arr[i]]) {
                visited[arr[i]] = true;
                arr[uniqueCount++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        return uniqueCount;
    }
}
