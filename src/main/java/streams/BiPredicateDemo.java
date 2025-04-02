package streams;

import java.util.function.BiPredicate;

public class BiPredicateDemo {

    public static void main(String[] args) {

        BiPredicate<Integer, String> biPredicate = (n, s) ->
                n == Integer.parseInt(s);

        System.out.println(biPredicate.test(2, "2"));
    }
}
