package streams;



import java.util.function.Supplier;
import java.util.stream.Stream;

public class CustomObjectSupplier {

    public static void main(String[] args) {
        Supplier<Person> personSupplier = () -> new Person("John Doe");

        Stream.generate(personSupplier)
                .limit(5)
                .forEach(System.out::println);
    }
}
record Person(String name){}