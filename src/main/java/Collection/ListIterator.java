package Collection;

import java.util.ArrayList;
import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class ListIterator {


    public static void main(String[] args) {

        Set<String> stringList = new HashSet<>();
        stringList.add("A");
        stringList.add("B");

        java.util.Iterator<String> itr = stringList.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
//            stringList.removeIf(ele -> ele.equals("A"));
//            itr.remove();

            stringList.remove(0);
//            stringList.add("H");

        }

        System.out.println(stringList); //A B C
    }
}
