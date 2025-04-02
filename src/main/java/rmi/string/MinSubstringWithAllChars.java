package rmi.string;

import java.util.*;

public class MinSubstringWithAllChars {

    public static int findMinSubstring(String input) {
        // Step 1: Find unique characters in the input
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : input.toCharArray()) {
            uniqueChars.add(c);
        }
        int requiredUniqueCount = uniqueChars.size();

        // Step 2: Sliding window variables
        Map<Character, Integer> charFrequency = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int uniqueCount = 0;

        // Step 3: Iterate with the end pointer
        for (int end = 0; end < input.length(); end++) {
            char endChar = input.charAt(end);
            charFrequency.put(endChar, charFrequency.getOrDefault(endChar, 0) + 1);

            // Count a character only when it appears for the first time in the window
            if (charFrequency.get(endChar) == 1) {
                uniqueCount++;
            }

            // Step 4: Shrink the window while it satisfies the condition
            while (uniqueCount == requiredUniqueCount) {
                minLength = Math.min(minLength, end - start + 1);

                char startChar = input.charAt(start);
                charFrequency.put(startChar, charFrequency.get(startChar) - 1);

                if (charFrequency.get(startChar) == 0) {
                    uniqueCount--;
                }

                start++;
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        String input = "abccdba";
        int result = findMinSubstring(input);
        System.out.println("Minimum substring length: " + result);
    }
}
