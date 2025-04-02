package array;

/*
for example, a =[45,7,9,12,1,29,13,26] and k=5, we can cover at most 3 points
			points=[7,9,12]: the difference between rightmost and leftmost point is equal to 12-7=5, which is equal to k.
			points=[9,12,13]: the difference between rightmost and leftmost point is equal to 13-9=4, which is less than k.
 */
public class RightAndLeftPointDiff {

    public static void main(String[] args) {
        int[] arr = {45, 7, 9, 12, 1, 29, 13, 26};
        int target = 5;
        int max = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i - 1];
            if (diff <= target && diff >= 0) {
                System.out.println(arr[i + 1] + " , " + arr[i - 1]);
            }
        }
    }
}
