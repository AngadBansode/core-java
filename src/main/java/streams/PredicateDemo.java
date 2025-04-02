package streams;

import java.util.function.Predicate;

public interface PredicateDemo<T> extends Predicate<T> {

    @Override
    default boolean test(T t){
        return t != null ? true : false;
    }
}
