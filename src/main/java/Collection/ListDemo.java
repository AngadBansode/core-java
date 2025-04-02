package Collection;

import java.util.*;

public class ListDemo {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        System.out.println(stringList);
        List<String> newList = new ArrayList<>(stringList);
        newList.add("D");
        System.out.println(newList);
        System.out.println(stringList);

        modifyList(stringList); // A B C
        System.out.println(stringList); //
        System.out.println(newList);
    }

    private static void modifyList(List<String> stringList) {
        stringList = new ArrayList<>();
        stringList.add("E");
        stringList.add("F");
    }


}
