package model;

import java.util.*;

// Address class
class Address implements Comparable<Address> {
    private String streetName;
    private String type; // Type of address (e.g., Home, Work, etc.)
    private int sequence; // Sequence number of the address

    public Address(String streetName, String type, int sequence) {
        this.streetName = streetName;
        this.type = type;
        this.sequence = sequence;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getType() {
        return type;
    }

    public int getSequence() {
        return sequence;
    }

    @Override
    public int compareTo(Address other) {
        int typeComparison = this.type.compareTo(other.type);
        if (typeComparison == 0) {
            return Integer.compare(this.sequence, other.sequence);
        }
        return typeComparison;
    }

    @Override
    public String toString() {
        return "Address{streetName='" + streetName + '\'' + ", type='" + type + '\'' + ", sequence=" + sequence + '}';
    }
}

// Person class
class Person {
    private String firstName;
    private List<Address> addresses;

    public Person(String firstName) {
        this.firstName = firstName;
        this.addresses = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public Address getPriorityAddress() {
        if (addresses.isEmpty()) {
            return null;
        }
        return Collections.min(addresses);
    }
}

// Main class to test functionality
public class PersonAddressMain {
    public static void main(String[] args) {
        Person person = new Person("John");

        // Add addresses
        person.addAddress(new Address("123 Elm Street", "Home", 2));
        person.addAddress(new Address("456 Oak Avenue", "Work", 1));
        person.addAddress(new Address("789 Pine Road", "Home", 1));

        // Get and print the priority address
        Address priorityAddress = person.getPriorityAddress();
        System.out.println("Priority Address: " + priorityAddress);
    }
}
