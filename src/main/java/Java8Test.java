import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Test {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 9, 0);
        Map<String, List<Integer>> partition = list.stream()
                .collect(Collectors.groupingBy(num -> num % 2 == 0 ? "EVEN" : "ODD"));
        System.out.println(partition);


        // even & odd unique ele
        var result = list.stream()
                .collect(Collectors.partitioningBy(even -> even % 2 == 0, Collectors.toSet()));
        System.out.println(result);
        System.out.println("Even: " + result.get(true) + " Odd: " + result.get(false));

        //Write a stream based program to replace duplicate number with zero
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 1, 2, 3, 6);
        Set<Integer> unique = new HashSet<>();

//        output - 1,2,3,4,0,0,0,6
        var resultListRepalced = list2.stream()
                .map(uni -> {
                    if (!unique.add(uni)) {
                        return 0;
                    } else
                        return uni;
                }).toList();
        System.out.println("Replaced: " + resultListRepalced);


        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 1, 2, 3, 6);
     var uniq=   list3.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(val -> val.getValue() == 1)
                .toList();
        System.out.println(uniq);



    }
}
