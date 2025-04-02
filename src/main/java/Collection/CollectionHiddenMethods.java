package Collection;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionHiddenMethods {

    public static void main(String[] args) {

    //1. Collection.nCopies() -- giving immutable list

    var copies=    Collections.nCopies(4, "Navya");
        System.out.println(copies);

    // 2. Collection.frequency
      List<Integer> nums = List.of(1,2,3,4,2,5,6,4,4);
      int freq =   Collections.frequency(nums, 4);
        System.out.println(freq);

     // find each ele count

        var integerMap = nums.stream()
                .collect(Collectors.toMap(number -> number, num  -> Collections.frequency(nums, num),
                (existing, newval) -> existing));

        System.out.println(integerMap);


    }
}
