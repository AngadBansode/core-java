package rmi.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCountString {

    public static void main(String[] args) {
        String text = "New York City, the most populous city in the United States, located in the state of NEW YORK";
          usingJava8(text);
        // Split the input text into words using regex to handle punctuation
        String[] words = text.split("\\W+");
        System.out.println("Array: " + Arrays.toString(words));

        // Use a HashSet to store unique words
        HashSet<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            if (word.length() <= 5) {
                uniqueWords.add(word.toUpperCase());
            }
        }

        // Print the unique words
        for (String word : uniqueWords) {
            System.out.println(word);
        }
    }

    private static void usingJava8(String text) {

        var stringSet = Arrays.stream(text.split("\\W+"))
                .filter(len -> len.length() <= 5)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        System.out.println("Set : " + stringSet);
    }
}
