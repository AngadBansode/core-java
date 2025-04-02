package streams;

import java.util.stream.Stream;

public class takeWhile {
    public static void main(String args[]) {
        Stream.of("India", "Australia", "Newzealand", "", "South Africa", "England","","Pakistan")
                .takeWhile(o->!o.isEmpty())
                .forEach(System.out::print);
    }
}
