package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MethodReference {

    public void main(String[] args) {
        List<String> stringList = Arrays.asList("Ravi", "Raju", "Priti", "Rahul", "Sachin");

        stringList.stream()
                .map(MethodReference::getLength)
                .forEach(System.out::println);
    }

    private static int getLength(String str) {
       return IntStream.rangeClosed(1,10)
                .boxed()
                .map(MethodReference::getIntLen)
                .findFirst()
                .get();

    }

    private static int getIntLen(int i){
        return 1;
    }
}

