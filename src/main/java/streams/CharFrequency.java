package streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// find the char frequency...max
public class CharFrequency {

    public static void main(String[] args) {
        String str = "shhhiivvvaa";
          char [] arr = str.toCharArray();


   // max char frequency
        System.out.println(Arrays.toString(str.split("")));

         var result = Arrays.stream(str.split(""))
                  .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                  .entrySet()
                  .stream().max(Map.Entry.comparingByValue()).get();

        System.out.println(result);

        // find each-char frequency

        var characterLongMap = str.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(characterLongMap);
    }

}
