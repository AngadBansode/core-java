package DS;


public class BinarySearch {

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13};//space - O(n) , time - O(log n)
        int target = 11;

        int result = binarySearchEle(sortedArray, target);
        if (result == -1)
            System.out.println("No element");
        else
            System.out.println(result);
    }

    private static int binarySearchEle(int[] sortedArray, int target) {
        int left = 0, right = sortedArray.length - 1;


        while (left <= right) {
            int mid = (left + right) / 2;
            if (sortedArray[mid] == target)
                return mid;
            else if (sortedArray[mid] < target) {
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return -1;
    }
}
