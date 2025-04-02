package streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ItemCode {

    public static void main(String[] args) {

//        orange 80 4000
//        banana 30 500
//        apple 26 426

        List<Item> items = Arrays.asList(
                new Item("apple", 5, new BigDecimal(5)), // 25
                new Item("apple", 20, new BigDecimal(20)), // 400 = 426
                new Item("apple", 1, new BigDecimal(1)), // 1
                new Item("banana", 10, new BigDecimal(10)),
                new Item("banana", 20, new BigDecimal(20)),
                new Item("orange", 60, new BigDecimal(60)), // 3600
                new Item("orange", 20, new BigDecimal(20))); // 400 = 4000

    // print output in the below format
        //orange 80 4000
//        banana 30 500
//        apple 26 426
        items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQuantity)))
          //    key - orange, value - 80
                .forEach((k,v) -> System.out.println(k + " " + v + " " + items.stream().filter(i -> i.getName().equals(k)).map(i -> i.getPrice().multiply(new BigDecimal(i.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add)));

       List<Item> out= items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQuantity)))
                .entrySet()
                .stream()
                .map(fruits -> new Item(fruits.getKey(),
                        fruits.getValue(),
                        items.stream().filter(i -> i.getName().equals(fruits.getKey()))
                                .map(i -> i.getPrice().multiply(new BigDecimal(i.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add))
                ).toList();

        out.forEach(System.out::println);

        int sum = IntStream.rangeClosed(1,10)
                .reduce(5, (l,r) -> l + r);
        System.out.println(sum);
    }

}

@Data
@AllArgsConstructor
class Item{
    private String name;
    private int quantity;
    private BigDecimal price;

}
