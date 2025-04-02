package rmi.string;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
//import javafx.util.Pair;

public class StringTransform {
    public static void main(String[] argv) {
        String message1 = "One does not simply walk into Mordor";
    /*. "Oe y Mnss ioe iwnr nmatddoploootlk r"
       char arr -- row1-
       Map<1, ListChar> - o n e  d o e  - col1
           2
       row1-6  -

    */
        int rows1 = 6;
        int cols1 = 6;

      /*  String message2 = "1.21 gigawatts!";
        int rows2_1 = 5;
        int cols2_1 = 3;
        int rows2_2 = 3;
        int cols2_2 = 5;
        int rows2_3 = 15;
        int cols2_3 = 1;

        String message3 = "M";
        int rows3 = 1;
        int cols3 = 1;*/
        String message4 = "M";
        int rows3 = 1;
        int cols3 = 1;
        String message2 = "I am okay";
        int rows2 = 3;
        int cols2 = 3;

        String message3 = "I love India soo much";
        int rows2_1 = 7;
        int cols2_1 = 3;
        String str = transpose(message3, rows2_1, cols2_1);
        System.out.print(str);
    }

    public static String transpose(String msg, int row, int col) {
        Map<Integer, List<Character>> map = new LinkedHashMap<>();

        char[] arr = msg.toCharArray();
        Character[] charObjectArray = ArrayUtils.toObject(arr);
        int tempRow = row;
        int colTemp = col;
        int j = 0;
        for (int i = 0; i < tempRow; i++) {
            map.put(i, Arrays.asList(charObjectArray).subList(j, col));
            j = col;//7.. 14
            col = col + colTemp; // 14 .. 14+ 14
        }

        System.out.println(map.size());
        StringBuilder builder = new StringBuilder();

        for (int k = 0; k < colTemp; k++) {
            for (int m = 0; m < tempRow; m++) {
                builder.append(map.get(m).get(k));
            }
        }

        return builder.toString();

    }

}