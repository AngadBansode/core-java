package streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyDemo {

    public static void main(String[] args) {
        var list = List.of(1,2,3,4,1,34,5,6,7,2,4,10);
        var fre = 2;

        var set = list.stream().filter(num -> Collections.frequency(list, num) >= fre)
                .collect(Collectors.toSet()) ;
        System.out.println(set);

    // find the occurrence of element

        var integerMap = list.stream().collect(Collectors.toMap(ele -> ele,
                ele -> Collections.frequency(list, ele), (existingVal, newVal) -> existingVal));

        System.out.println(integerMap);
    }
}
