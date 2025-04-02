package rmi.string;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class StringCountInDescOrder {
    public static void main(String[] args) {

       /*  1st solution
       String s = "This is a sample text. The text may contain words, punctuation, and spaces. This sample text is for testing";
        System.out.println(Arrays.stream(s.split(" ")).map(inputString -> inputString.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase()).
                collect(Collectors.groupingBy(x -> x, Collectors.reducing(0, e -> 1, Integer::sum))).entrySet()
                .stream().sorted((x, y) -> {
                    int z = y.getValue() - x.getValue();
                    if(z!=0)
                        return z;
                    int i = x.getKey().compareTo(y.getKey());
                    return i!=0 ? -i: i;
                }).toList()
        );*/

     // 2nd solution
        String s = "This is a sample text. The text may contain words, punctuation, and spaces. This sample text is for testing";
        Map<String, Long> wordFrequencyMap = Arrays.stream(s.toLowerCase().split("\\s+"))
                .map(inputString -> inputString.replaceAll("[^a-zA-Z0-9\\s]", ""))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        // Sort the map entries by value in descending order, and if counts are the same, sort by key (word) alphabetically
        wordFrequencyMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
