package immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

final class Person {
    private final String name;
    private final List<Address> address;

    public Person(String name, List<Address> address) {
        this.name = name;

        // Defensive copy to prevent external modifications
        this.address = address == null ? Collections.emptyList() :
                Collections.unmodifiableList(new ArrayList<>(address));
    }

    public String getName() {
        return name;
    }

    public List<Address> getAddress() {
        // Return an unmodifiable view of the address list
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
