package rmi.string;

public class MinSwapForMinDiff {

    private static String string1 = "";
    private static String string2 = "";
    private static int minValue = Integer.MAX_VALUE;
    private static int counter = 0;

    public static void main(String[] args) {
        System.out.println(solution("29162", "10524"));
    }

    public static int solution(String S, String T) {
        // Implement your solution here
        string1 = S;
        string2 = T;
        if (S.length() != T.length())
            return -1;
        if (S.charAt(0) > T.charAt(0))
            findTheDiff(S, T); // 20122 , 19564 // 668, min = 558
        return counter;
    }

    public static int findTheDiff(String s1, String s2) {

        for (int i = 1; i < s1.length() - 1; i++) {
            if (s1.charAt(i) > s2.charAt(i))
                swap(i);
        }
        return counter;
    }

    public static int swap(int index) {


        char[] charArrayS1 = string1.toCharArray();
        char[] charArrayS2 = string2.toCharArray();
        char temp = charArrayS1[index];
        charArrayS1[index] = charArrayS2[index];
        charArrayS2[index] = temp;
        string1 = new String(charArrayS1);
        string2 = new String(charArrayS2);
        // check the min diff
        int n1 = Integer.parseInt(string1);
        int n2 = Integer.parseInt(string2);
        int min = n1 - n2; // 400
        if (min < minValue) {
            minValue = min;  // minval = 400
            counter++;
        }
        return counter;
    }
}
