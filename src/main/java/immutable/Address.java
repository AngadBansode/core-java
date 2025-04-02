package immutable;

import java.util.Objects;

final class Address {
    private final String city;
    private final int phno;

    public Address(String city, int phno) {
        this.city = city;
        this.phno = phno;
    }

    public String getCity() {
        return city;
    }

    public int getPhno() {
        return phno;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", phno=" + phno +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return phno == address.phno && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, phno);
    }
}
