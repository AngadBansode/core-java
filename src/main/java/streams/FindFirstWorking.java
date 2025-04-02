package streams;

import java.util.*;
import java.util.stream.Stream;

public class FindFirstWorking {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

     var first =   list.stream()
                .filter(x -> x % 2 == 0)
                .findAny()
                .orElse(0);
//        System.out.println(first);


        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int findAny =   list2.parallelStream()
                   .findAny().get();
        System.out.println(findAny);

    /*    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int findAny =   list .stream()
                .findAny().get();
        System.out.println(findAny);*/

        Stream<String> parallelStream = Stream.of("A", "B", "C", "D").parallel();
        System.out.println("Parallel Stream: " + parallelStream.findAny().orElse("None"));

    }

}
