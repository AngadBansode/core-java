package fuctional;
// same type argument and return same type value

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        UnaryOperator<Integer> square = x -> x * x;

        // Apply the operator
        int result = square.apply(5);

        System.out.println("Square of 5 is: " + result); // Output: Square of 5 is: 25

        // more specialized version
        IntUnaryOperator add = y -> y+y;
        System.out.println("Add: " + add.applyAsInt(10));

    }
}
