package rmi.string;

import java.util.LinkedHashSet;
import java.util.Set;

// find the longest length of non-repeating substring
// ex.. aabcdde  , output --2, bc
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String str = "aabcdde";//"aabcfghhik";//"au";//"pwwkee";// "au";//"bbbbb";//"aabcdde";//"abcabcdd"; // "pwwkew"; // abcd
        if (str.length() == 0) {
            System.out.println(0);
            return;
        }
        int cnt = 0;
        int actual = 0;
        Set<Character> set = new LinkedHashSet<>();

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1) && set.add(str.charAt(i))) {
                cnt++;
            } else {
                actual = Math.max(actual, cnt);//2
                cnt = 0;
                set.add(str.charAt(i));
            }
        }
        actual = Math.max(actual, cnt);//2
        if (actual == 0)
            System.out.println(1);
        else if (str.length() - 1 == cnt)
            System.out.println(str.length());
        else
            System.out.println(actual);
    }
}
