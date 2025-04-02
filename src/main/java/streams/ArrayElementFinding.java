package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArrayElementFinding {

    public static void main(String[] args) {

        int arr[] = {12,23,2,78,98,11,100};

        //1. 2nd highest no.

        var first = Arrays.stream(arr).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println(first);

    }
}
