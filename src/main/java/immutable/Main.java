package immutable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address("New York", 123456789);
        Address address2 = new Address("Los Angeles", 987654321);

        Person person = new Person("John Doe", Arrays.asList(address1, address2));

        System.out.println(person);

        // Attempting to modify address list will fail
        try {
            person.getAddress().add(new Address("San Francisco", 111222333));
        } catch (UnsupportedOperationException e) {
            System.out.println("Modification is not allowed!");
        }
    }
}
