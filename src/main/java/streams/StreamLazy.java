package streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamLazy {

    public static void main(String[] args) {

        var evenElement = List.of(1, 2, 3, 4, 5, 6, 7, 8).stream().filter(even -> even % 2 == 0).onClose(() ->
         Stream.of(1,2) );

         evenElement.forEach(System.out::println) ;
    }
}
