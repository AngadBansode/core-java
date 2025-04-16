import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NTTTest {

    public static void main(String[] args) {

        String str = "I am a java developer am";
        String emp = "   ";
        System.out.println("Len: " + emp.isBlank());

        System.out.println("IsNull :" + Objects.nonNull(emp));
//        give the count of each letter
       char [] arr =  str.toCharArray();
        var result = str.chars().mapToObj(ch -> (char) ch)
                .filter(chaLen ->  !chaLen.toString().isBlank())
                 .collect(Collectors.groupingBy(unichar -> unichar,Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)->e2, LinkedHashMap::new));

        System.out.println(result);


    }
}
