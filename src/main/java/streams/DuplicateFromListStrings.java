package streams;

import java.util.Arrays;
import java.util.List;

// remove duplicates from List<List<String>
public class DuplicateFromListStrings {

    public static void main(String[] args) {
        List<List<String>> nestedLists = Arrays.asList(
                Arrays.asList("A", "B", "A"),
                Arrays.asList("C", "D", "E", "D", "F"),
                Arrays.asList("F", "A")
        );

        List<String> result = nestedLists.stream()
                .flatMap(list ->
                        list.stream().distinct().toList().stream()
                ).toList();

        System.out.println(result);

    }
}
