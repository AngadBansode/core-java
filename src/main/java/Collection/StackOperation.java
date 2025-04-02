package Collection;

import java.util.Stack;

public class StackOperation {
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        String s = "4 5 6 - 7 +"; // 4 5 6 == 5-6 -1
           // print(solution("1048575 DUP +"))
        System.out.println(doOperations(s));
    }

    private static int doOperations(String s) {
        String[] arr = s.split(" ");
        for (String ele : arr) {

            if (ele.matches("-?\\d+")) {
                stack.push(Integer.parseInt(ele));
            } else if (ele.equals("Dup")) {
                if (!stack.isEmpty())
                    stack.push(stack.peek());
            } else if (ele.equals("+")) {
                if (!stack.isEmpty() && stack.size() >= 2) {
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    stack.push(n1 + n2);
                }
            } else if (ele.equals("-")) {
                if (!stack.isEmpty() && stack.size() >= 2) {
                    int n1 = stack.pop(); // top
                    int n2 = stack.pop(); // 2nd top
                    stack.push(n1 - n2); // 5-6
                }
            } else if (ele.equals("pop"))
                if (!stack.isEmpty())
                    stack.pop();
        }

        return stack.peek(); // top - 6
    }
}
