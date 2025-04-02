package rmi.string;

import java.util.*;
import java.util.stream.Collectors;

/*Find minimum substring length which consists all
        the characters of a given string. Example : Input : abccdba Output : 5(abccd)
 */
public class SubstringAllChars {

    public static void main(String[] args) {//aabcabc - 3 //abccdba - 5
        var input = "dabaccdbaaabcd";
        String output = findMinSubstring(input);
        System.out.println(output);
        System.out.println(output.length());
    }

    private static String findMinSubstring(String input) {

        Set<Character> characterSet = new HashSet<>();
        input.chars().forEach(character -> characterSet.add((char) character));
        StringBuilder substring = new StringBuilder();
        Set<Character> anotherSet = new HashSet<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            substring.append(input.charAt(i));
            anotherSet.add(input.charAt(i));
            if (anotherSet.containsAll(characterSet)) {
                treeMap.put(substring.length(), substring.toString());
                substring = new StringBuilder();
                anotherSet.clear();
            }
        }
        System.out.println(treeMap);

        return treeMap.firstEntry().getValue();
    }

}