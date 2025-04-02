package streams;
//stream.collect(arg1, arg2, arg3)

import java.util.*;
import java.util.stream.Collectors;

public class CollectDemo {

    public static void main(String[] args) {
 List<Integer> list ;
        Set<Integer> integerSet = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,2,4,6,9);

        //1. way
        var hashSet = integerSet.stream()
                .collect(HashSet::new, HashSet::add, AbstractCollection::addAll);

        System.out.println(hashSet);

        //2. way
                  integerSet.stream()
                          .collect(Collectors.toCollection(() -> { return new ArrayList<Integer>();}));

    }
}

