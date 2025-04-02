package code;

public class PeakElementFromArray {
    public static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
//            1, 2, 1, 3, 5, 6, 4

            if (nums[mid] > nums[mid + 1]) {
                // Peak is on the left half (including mid)
                high = mid;
            } else {
                // Peak is on the right half (excluding mid)
                low = mid + 1;
            }
        }

        // At the end of the loop, low == high, pointing to a peak
        return low;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 1, 3, 5, 6, 4};// peak ele index:5
        int [] nums = {1, 12, 21, 3, 5, 6, 4};
        int peakIndex = findPeakElement(nums);
        System.out.println("Peak element index: " + peakIndex);
    }
}
