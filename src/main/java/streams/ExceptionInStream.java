package streams;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ExceptionInStream {

    public static void main(String[] args) {

        Map<Integer,String> map = new HashMap<>();
         map.put(101,"Ravi");
        map.put(102,"Rahul");
        map.put(103,"Angad");
        map.put(104,"Krishna");

        map.entrySet()
                .stream()
                .filter(keys -> keys.getKey() >=103)
                .map(values -> values.getValue().toUpperCase())
                .forEach(ExceptionInStream::accept);


    }

    private static void accept(String ele) {
        System.out.println("values:" + ele);
    }
}
