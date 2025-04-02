package streams;

import java.util.stream.Stream;

public class dropWhile {
    public static void main(String args[]) {
        Stream.of("India", "Australia", "Newzealand", "", "England", "Srilanka")
                .dropWhile(o->!o.isEmpty())
                .forEach(System.out::print);
        System.out.println();
        Stream.of("India", "", "Australia", "", "England", "Srilanka")
                .dropWhile(o->!o.isEmpty())
                .forEach(System.out::print);
    }
}
