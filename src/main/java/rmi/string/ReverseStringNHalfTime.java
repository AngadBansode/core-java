package rmi.string;

public class ReverseStringNHalfTime {

    public static void main(String[] args) {

        String str = "abcdef";

        System.out.println(reverseString(str));
    }

    private static String reverseString(String str) {

        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            // swap chars in place
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }
}
