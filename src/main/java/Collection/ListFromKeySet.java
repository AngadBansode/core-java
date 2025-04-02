package Collection;

import java.util.*;

public class ListFromKeySet {
    public static void main(String[] args) {
        //create Map with some entries

        Map<String, Integer> map = Map.of("one", 1, "two", 2, "three", 3);

        List<String> list = new ArrayList<>(map.keySet());
        System.out.println(list.size());
        System.out.println(list.get(0));

        Set<Integer> integerSet = Set.of(1, 2, 3, 4, 5);

        //  integerSet.add(6);
        List<Integer> listSize = new ArrayList<>(integerSet.size());//initial capacity of list
        System.out.println(listSize.size()); // 0


        List<Integer> newList = new ArrayList<>(integerSet);
        System.out.println(newList.size()); // 5

    }
}
