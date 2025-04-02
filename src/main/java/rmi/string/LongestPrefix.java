package rmi.string;

import java.util.Arrays;
import java.util.Optional;

public class LongestPrefix {

    public static void main(String[] args) {

        String[] strs = {"flower", "flog", "float", "flot"};
        // output - fl

        Optional<String> prefix = Arrays.stream(strs)
                .reduce((s1, s2) -> {
                    int minLength = Math.min(s1.length(), s2.length());
                    int i = 0;
                    while (i < minLength && s1.charAt(i) == s2.charAt(i)) {
                        i++;
                    }
                    return s1.substring(0, i);
                });

        System.out.println("Longest Common Prefix: " + prefix.orElse(""));
    }
}
