package streams;

import java.util.*;
import java.util.concurrent.ForkJoinPool;

/* steps parallelStream

    Input collection

    Spliterator splitting

    ForkJoinPool threads processing

    Merging results

* */

public class ParallelStreamInternalWorking {
    public static void main(String[] args) {



     /*   System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "5");

        List<String> list = Arrays.asList("a", "b", "c", "d");

        list.parallelStream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
                */
        var core = Runtime.getRuntime().availableProcessors();
        System.out.println("Core: " + core); // 8


        usingCustomForkJoin();

        var core2 = Runtime.getRuntime().availableProcessors();
        System.out.println("Core2: " + core2); // 8

//        parallelWithForEachOrdered();
    }

    private static void parallelWithForEachOrdered() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        list.parallelStream()
                .map(String::toUpperCase)
                .forEachOrdered(System.out::println);

    }

    // Custom ForkJoinPool
    //You can also use a custom ForkJoinPool instead of the default one if you want more control:
    private static void usingCustomForkJoin() {

        System.out.println("CommonPool before: "+ ForkJoinPool.commonPool().getParallelism());
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");


//        List<String> list = Arrays.asList("a", "b", "c", "d");
//        ForkJoinPool customPool = new ForkJoinPool(Integer.parseInt(System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism")));
        System.out.println("CommonPool: "+ ForkJoinPool.commonPool().getParallelism());
//        System.out.println("parallelism : " + customPool.getParallelism());// 2
//        customPool.submit(() ->
//                list.parallelStream()
//                        .map(String::toUpperCase)
//                        .sequential()
//                        .forEach(System.out::println)
//        ).join();
//
//        customPool.shutdown();
    }
}
