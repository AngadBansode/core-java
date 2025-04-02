import java.util.Arrays;
import java.util.stream.Collectors;

/*Given the .
        Select only words which contains no more than 5 characters, convert them to uppercase.
        Print converted words without duplicates.*/
public class NewCodingTask {

    public static void main(String[] args) {
        String text = "New York City, the most populous city in the United States, located in the state of NEW YORK";

        convertTheText(text);
    }

    private static void convertTheText(String text) {
/*
       var result = Arrays.stream(text.split("\\W+"))
                .filter(len -> len.length() <=5)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        System.out.println(result);*/


      var result=  Arrays.stream(text.split(" "))
                  .filter(item -> item.length() <= 5)
                  .distinct()
                  .map(String::toUpperCase)
                  .toList();

        System.out.println(result);
    }

}
