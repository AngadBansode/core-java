package java17;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//Pair<Key Type, Value Type> var_name = new Pair<>(key, value);
public class PairDemo {

    public static void main(String[] args)
    {

        HashSet set = new HashSet<>(Set.of(1, 2, 3, 4, 5));
        System.out.println(set.size());

        List list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        list.add("");
        System.out.println(list.size());


        Pair<String,Integer> pair = Pair.of("key", 1);
        System.out.println(pair.getKey());
    }
}
