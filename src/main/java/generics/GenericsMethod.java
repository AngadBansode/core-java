package generics;

import java.util.List;

public class GenericsMethod {

    public static  < T > void printElement(List<T> list){
        System.out.println(list);
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(12,23,1,1);

        List<String> stringList = List.of("A","B","C");

        printElement(integerList);
        printElement(stringList);
    }
}
