package rmi.string;

import java.util.HashMap;
import java.util.Map;

// check two strings are Isomorphic or not
public class IsomorphicString {

    public static void main(String[] args) {

        String str1 = "abbcdd";
        String str2 = "qwwcrr";
        boolean flag = false;
        Map<Character, Character> map = new HashMap<>();
        if (str1.length() != str2.length() && !str1.isBlank() && !str2.isBlank())
            return;
        for (int i = 0; i <= str2.length() - 1; i++) {

            if (map.containsKey(str1.charAt(i))) {
                if (!(map.get(str1.charAt(i)).toString().equals(String.valueOf(str2.charAt(i))))) {
                    flag = true;
                    System.out.println("Not Isomorphic ");
                    break;
                }
            } else
                map.put(str1.charAt(i), str2.charAt(i));
        }

        if (!flag)
            System.out.println("Isomorphic");
    }
}
