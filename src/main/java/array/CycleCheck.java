package array;

import java.util.Arrays;

public class CycleCheck {

    public static void main(String[] args) {
        int[] arr = {1,3,0,1};

        checkCycle(arr, 0);
    }

    private static void checkCycle(int[] arr, int index) {
        int count = 0;
        boolean[] visited = new boolean[arr.length];
//         visited[0] = true;  1 2 0
        for (int i = 0; i < arr.length; i++) {

            if (visited[arr[i]]) {
                System.out.println("visited");
                 break;
            }
            count++;
            visited[arr[i]] = true; // 0-true 1-true
        }
        System.out.println(Arrays.toString(visited));
        System.out.println("length: " + count);
    }
}
