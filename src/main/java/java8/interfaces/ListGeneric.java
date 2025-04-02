package java8.interfaces;

import java.util.List;


public class ListGeneric {
    public static void main(String[] args) {
        List<Number> integerList = List.of(12.23, 34l, 66.33f, 354, 0.0);

        printList(integerList);
    }

    private static void printList(List<? super Number> integerList) {

        integerList.forEach(System.out::println);
    }
}
