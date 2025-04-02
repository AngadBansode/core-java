package streams;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreams {

    public static void main(String[] args) {
       /* System.out.println("forEach Demo");
        Stream.of("AAA","BBB","CCC").forEach(s->System.out.println("Output:"+s));
        System.out.print("\n");
        System.out.println("forEachOrdered Demo");
        Stream.of("AAA","BBB","CCC").forEachOrdered(s->System.out.println("Output:"+s));*/


//        Stream.of("AAA","BBB","CCC").parallel().forEach(s->System.out.println("Output:"+s));
//        System.out.print("\n");
//        Stream.of("AAA","BBB","CCC").parallel().forEachOrdered(s->System.out.println("Output:"+s));
//
//
//        // 2. Parallel() & Sequential() method demo
//        IntStream.rangeClosed(1,10)
//                .forEach(no -> System.out.println("Sequential -ThreadName: " + Thread.currentThread().getName() +": " + no ));//main
//
//        IntStream.rangeClosed(1,10).parallel()
//                .forEach(no -> System.out.println("Parallel -ThreadName: " + Thread.currentThread().getName() +": "+  no ));// main, ForkJoinPool.commonPool-worker-1

        long start, end;
        start  = System.currentTimeMillis();
        IntStream.rangeClosed(1,10)
                .forEach(no -> System.out.println("Sequential -ThreadName: " + Thread.currentThread().getName() +": " + no ));//main
       end = System.currentTimeMillis();

        System.out.println("Sequential Time Taken: " + (end-start));

        System.out.println("====================================================================================");

        start  = System.currentTimeMillis();
        IntStream.rangeClosed(1,10).parallel()
                .forEach(no -> System.out.println("Sequential -ThreadName: " + Thread.currentThread().getName() +": " + no ));//main
        end = System.currentTimeMillis();
        System.out.println("Parallel Time Taken: " + (end-start));
    }
}
