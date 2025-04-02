package fuctional;

import java.util.function.BiFunction;

public class BiFuctionalDemo implements BiFunction {

    @Override
    public Object apply(Object o, Object o2) {
        return o.toString().equals(o2.toString());
    }

    public static void main(String[] args) {
        BiFuctionalDemo demo = new BiFuctionalDemo();
        System.out.println(demo.apply("First","Second"));

        // using lambda

      BiFunction<Integer,Integer,Integer> add = Integer::min;

        System.out.println(add.apply(10,20));

        Object c = null;
        BiFunction myBiFunction = (a, b) -> b;

        System.out.println(myBiFunction.apply(1,2));

    }

}
