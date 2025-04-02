package code;

import java.util.ArrayList;
import java.util.Collections;

// convert given no to binary format and find the max gap
// gap - max no of zeros between two one (10010001) gap - 3
public class ConvertBinaryFindMaxGap {
    public static void main(String[] args) {

        int number = 15;
        ArrayList<Integer> al = convertBinary(number);
        Collections.reverse(al);
        System.out.println(al.get(0));
        System.out.println(al.toString());
// 1111
        int max = 0;
        int i = 0;
        int j = 1;
        while (j < al.size()) {

            if (al.get(j) == 1) {
                max = Math.max(max, j - i - 1);
                i = j;
            }
            j++;
        }
        System.out.println(max);

    }

    private static ArrayList<Integer> convertBinary(int number) {
        ArrayList<Integer> al = new ArrayList<>();
        while (number > 0) {
            al.add(number % 2);
            number /= 2;
        }
        return al;
    }
}
