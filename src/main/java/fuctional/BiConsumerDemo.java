package fuctional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BiConsumerDemo {
    public static void main(String[] args) {

        BiConsumer<Number,Number> consumerAdd = (n1,n2) -> System.out.println("Added: " + (n1.intValue()+n2.intValue()));
        consumerAdd.accept(12.32,20);

        Consumer<String> upperCase = name -> System.out.println(name.toUpperCase());
         upperCase.accept("Angad");

        Map<String, Integer> map = new HashMap<>();
            map.put("A1", 101);
            map.put("A2", 102);
            map.put("B1", 103);
            map.put("B2", 104);

            map.forEach((k,v) -> System.out.println("key: " + k +" , value: " + v));

        List<Integer> list = List.of(1,2,3,4,5);
         list.forEach(System.out::println);

    }
}
