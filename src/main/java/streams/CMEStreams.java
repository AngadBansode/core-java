package streams;

import java.util.Arrays;
import java.util.List;

public class CMEStreams {

    public static void main(String[] args) {

        List duplicate= Arrays.asList(1,2,3,4,5,6,7);

        duplicate.stream().
                filter(ele -> { return true;}).
                map(elel -> {duplicate.add(8910); // java.lang.UnsupportedOperationException
                    return elel.toString();
                }).
                forEach(System.out::print);

    }
}
