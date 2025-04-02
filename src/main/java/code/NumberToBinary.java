package code;

import java.util.Stack;

public class NumberToBinary {

    // Function to convert integer to binary
    static void decimalToBinary(int num)
    {
        // Creating Stack Object Vector
        Stack<Integer> st = new Stack<>();

        // Number Should be positive
        while (num > 0) {

            // Pushing numbers inside stack that
            // are divisible by 2
            st.push(num % 2);
            // Dividing number by 2
            num = num / 2;
        }

        // Checking condition whether stack is empty
        while (!(st.isEmpty())) {

            // Printing binary number
            System.out.print(st.pop());
        }
    }

    // Main driver function
    public static void main(String[] args)
    {
        // Entered number to be converted into binary
        int num = 10;
        decimalToBinary(num);
    }
}
