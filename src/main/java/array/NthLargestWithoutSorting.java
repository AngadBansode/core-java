package array;

public class NthLargestWithoutSorting {

    public static int findNthLargest(int[] arr, int n) {
        if (n < 1 || n > arr.length) {
            throw new IllegalArgumentException("Invalid value of n");
        }
        return quickselect(arr, 0, arr.length - 1, arr.length - n);
    }

    private static int quickselect(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int pivotIndex = partition(arr, low, high);
            if (pivotIndex == k) {
                return arr[pivotIndex];
            } else if (pivotIndex > k) {
                return quickselect(arr, low, pivotIndex - 1, k);
            } else {
                return quickselect(arr, pivotIndex + 1, high, k);
            }
        }
        return -1; // This should not happen if the input is valid
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int n = 6;
        int nthLargest = findNthLargest(arr, n);
        System.out.println("The " + n + "th largest number in the array is: " + nthLargest);
    }
}
