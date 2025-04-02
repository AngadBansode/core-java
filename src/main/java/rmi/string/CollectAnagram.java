package rmi.string;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class CollectAnagram {

    public static void main(String[] args) {
        String[] anagram = {"cat", "act", "bat", "tab", "rat", "tra"};

        List<List<String>> result = new ArrayList<>(Arrays.stream(anagram)
                .collect(Collectors.groupingBy(w -> {
                    char[] ch = w.toCharArray();
                    Arrays.sort(ch); // act
                    return new String(ch); // abt
                })).values());

        System.out.println(result);

        Arrays.stream(anagram)
                .collect(Collectors.groupingBy(w -> {
                    char[] ch = w.toCharArray();
                    Arrays.sort(ch);
                    return new String(ch);
                })).forEach((k,v) -> System.out.println("Key: " + k + ": " + v));

    }
}
