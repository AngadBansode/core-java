package fuctional;

import java.util.function.Function;
import java.util.stream.Stream;

public interface FunctionInterface<T,  R> {

    <R> Stream<R> mapCustom(Function<? super T, ? extends R> mapper);
}
