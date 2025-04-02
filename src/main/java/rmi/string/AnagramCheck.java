package rmi.string;

// Input: str1 = “listen”  str2 = “silent”
//Output: “Anagram”
//Explanation: All characters of “listen” and “silent” are the same.
//
//Input: str1 = “gram”  str2 = “arm”
//Output: “Not Anagram”
public class AnagramCheck {

    public static void main(String[] args) {
        String str1 = "motherinlaw";
        String str2 = "hitlerwoman";

        boolean check = checkAnagram(str1, str2);
        System.out.println(check);
    }

    private static boolean checkAnagram(String str1, String str2) {

        for (int i = 0; i < str1.length(); i++) {

            if (str1.length() != str2.length())
                return false;
            else if (!str1.contains(String.valueOf(str2.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
