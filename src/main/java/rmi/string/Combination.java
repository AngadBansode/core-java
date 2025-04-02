package rmi.string;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

// ABC
public class Combination {

    static Set<String> combination = new LinkedHashSet<>();

    public static void main(String[] args) {
        String input = "123";
        combination.add(input);

        for (int i = 0; i < input.length(); i++) {
            swapCall(i, input);
        }

        System.out.println(combination);

    }

    private static void swapCall(int i, String input) {
        char arr[] = input.toCharArray();
        if (i == input.length() - 1) {
            StringBuilder reverse = new StringBuilder(input).reverse();
            arr = reverse.toString().toCharArray();
            i = 0;
            combination.add(String.valueOf(arr));

        }

        for (int j = i; j < input.length() - 1; j++) {
            char temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
            combination.add(String.valueOf(arr));

        }
        combination.add(String.valueOf(arr));

    }
}
