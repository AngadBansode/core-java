package fuctional;

import java.util.function.BiPredicate;

public class BiPredicateDemo {

    public static void main(String[] args) {

        BiPredicate<String, String> predicate = (s1,s2) -> !s1.equals(s2);
        System.out.println(predicate.test("Raj", "Raj"));
        System.out.println("negate: " + predicate.negate().test("nitin","nitin"));
    }
}
