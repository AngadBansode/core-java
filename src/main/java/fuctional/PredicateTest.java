package fuctional;

import java.util.function.Predicate;

public interface PredicateTest<T> extends Predicate<T> {
    @Override
    default boolean test(T t) {
        return true;
    }

    static void display(){
        System.out.println("hello");
    }
}
