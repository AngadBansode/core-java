package fuctional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// List<String> asList = stringStream
// .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//
public class CollectDemo {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("A", "B", "D", "B");
        List<String> asList = stringStream.distinct()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println(asList);


    }
}
