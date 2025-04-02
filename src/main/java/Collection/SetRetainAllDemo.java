package Collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetRetainAllDemo {

    public static void main(String[] args) {

        Set<Integer> integerSet_1  = new HashSet<>(Arrays.asList(2,1,3,4,5,6));
        Set<Integer> integerSet_2  = new HashSet<>(Arrays.asList(1,2,3,4));

        if(integerSet_1.retainAll(integerSet_2)){
            System.out.println("Matched");
         }else
            System.out.println("Not Matched");


        System.out.println(integerSet_1);
        System.out.println(integerSet_2);
        System.out.println(integerSet_1.isEmpty());
    }

}
