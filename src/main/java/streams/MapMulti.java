package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapMulti {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        // mapMulti
        var stringStream = list.stream().mapMulti((s, consumer) ->
                consumer.accept(s)).filter(s -> s.equals("a"));
//        System.out.println(stringStream.collect(Collectors.toList()));


        List<String> list1 = Arrays.asList("1", "2"," ", "3");
        var integerList = list1.stream()
                .flatMap(s -> {
                    try {
                        return Stream.of(Integer.parseInt(s));
                    } catch (NumberFormatException e) {
                        return Stream.empty();
                    }
                }).peek(size -> System.out.println(size))
                .collect(Collectors.toList());

        System.out.println(integerList.size());
    }
}