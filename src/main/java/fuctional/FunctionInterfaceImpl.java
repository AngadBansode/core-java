package fuctional;

import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionInterfaceImpl implements FunctionInterface {
    @Override
    public Stream mapCustom(Function mapper) {
        System.out.println("mapCustom :" + mapper.apply(24));
        return null;
    }


    public static void main(String[] args) {
        double d = 10.9;

        Function<Integer, Integer> doubleIntegerFunction = i -> i * 2;

        System.out.println(doubleIntegerFunction.apply(12));
        new FunctionInterfaceImpl().mapCustom(doubleIntegerFunction);

    }
}
