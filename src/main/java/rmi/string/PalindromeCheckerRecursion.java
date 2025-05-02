package rmi.string;

public class PalindromeCheckerRecursion {

    // Recursive function to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        // Base case: A string of length 0 or 1 is a palindrome
        if (str.length() <= 1) {
            return true;
        }

        // Check the first and last characters
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }

        // Recursive call: Check the substring excluding the first and last characters
        return isPalindrome(str.substring(1, str.length() - 1));
    }

    public static void main(String[] args) {
        String testString = "radar";
        System.out.println("Is \"" + testString + "\" a palindrome? " + isPalindrome(testString));

        testString = "hello";
        System.out.println("Is \"" + testString + "\" a palindrome? " + isPalindrome(testString));
    }
}
