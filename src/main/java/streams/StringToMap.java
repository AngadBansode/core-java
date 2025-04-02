package streams;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringToMap {

    public static void main(String[] args) {
        String[] arr = ":d".split(":");
        System.out.println(arr.length);
        System.out.println("Arr: " + arr[0]);

        String[] str2 = "boo:and:foo".split(":");
        System.out.println(str2.length);


        Map<String, Integer> result = Stream.of("a:332", "b:42", "c:", ":d", "g", "f:2345", "i:-34")
                .filter(s -> s.matches("^[^:]+:-?\\d+$")) // Ensure the string matches the format "key:value"
                .collect(Collectors.toMap(
                        s -> s.split(":")[0], // Key is the part before ':'
                        s -> Integer.parseInt(s.split(":")[1]) // Value is the integer after ':'
                ));

        System.out.println(result); // Output: {a=332, b=42, f=2345, i=-34}
    }


}


