package array;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ArrayCloseAddition {

    public static void main(String[] args) {
        int target = 3;
        Integer arr[] = {1, 2, 4, 5, 1,1};
        int sum = 0;
        List list = Arrays.asList(arr);
        System.out.println( "list "+ list );
        Set<Integer> index = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if ( list.contains(target+1)) {
                if(arr[i] == target || arr[i] == target +1)
                    continue;
                sum += arr[i];
                index.add(i);
            }
            if ( sum == target + 1 ) {
                break;
            }else if(sum > target +1 )
                sum = sum -arr[i];
               index.remove(i);
        }
        // print array
        System.out.println("sum - "+ sum);
        for (Integer i : index) {
            System.out.println(arr[i]);
        }
    }
}
