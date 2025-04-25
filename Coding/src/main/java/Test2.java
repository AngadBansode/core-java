import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {
        String input = "this is Angad this is Angad";
        var result = Arrays.stream(input.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println(result);

        String duplicate = "this is Angad this is Angad";
        Set<String> set = new HashSet<>() ;
         Arrays.stream(duplicate.split(" "))
                 .filter(uni -> !set.add(uni))
                 .forEach(System.out::println);

    }
}
