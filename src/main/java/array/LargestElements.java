package array;

public class LargestElements {

    public static void main(String[] args) {
        int[] array = {10, 20, 4, 45, 99, 56, 45, 99};

        // Find largest and second largest
        findLargestAndSecondLargest(array);
    }

    public static void findLargestAndSecondLargest(int[] array) {
        if (array == null || array.length < 2) {
            System.out.println("Array must have at least two elements.");
            return;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest element (all elements might be equal).");
        } else {
            System.out.println("Largest element: " + largest);
            System.out.println("Second largest element: " + secondLargest);
        }
    }
}
