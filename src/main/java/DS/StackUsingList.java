package DS;

import java.util.*;

// impl stack using list
public class StackUsingList {
    static List<Integer> list = new LinkedList<>();
    public static void main(String[] args) {

        push(1);
        push(2);
        pop();
        top();
        push(3);
        push(5);
        top();
        pop();
        pop();
        pop();
        pop();
        printStack();
    }

    private static void top() {
        System.out.println("top: " + list.get(list.size()-1));
    }

    private static void printStack() {

        System.out.println(list);
    }

    private static void pop() {
        if(list.size()> 0)
        System.out.println(list.remove(list.size()-1));
        else
            System.out.println("stack is empty");
    }

    private static void push(int i) {

        list.add(i);
    }
}
