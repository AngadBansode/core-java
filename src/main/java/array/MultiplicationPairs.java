package array;

import java.util.Scanner;

public class MultiplicationPairs {
    public static void main(String[] args) {

        int target = 57;
        System.out.println("Pairs of numbers whose product equals " + target + ":");
        System.out.println(Math.sqrt(Math.abs(target)));
        // Find and print pairs
        for (int i = 2; i <= Math.sqrt(Math.abs(target)); i++) {
            if (target % i == 0) {
                int pair = target / i;
                System.out.println("(" + i + ", " + pair + ")");
//                if (i != pair) { // Avoid duplicates for perfect squares
//                    System.out.println("(" + (-i) + ", " + (-pair) + ")");
//                }
            }
        }


    }
}
