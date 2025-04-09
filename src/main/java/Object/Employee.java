package Object;


import java.util.Objects;

public class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee person = (Employee) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main(String[] args) {

        Employee e1 = new Employee("Angad", 25);
        Employee e2 = new Employee("Angad", 25);
        System.out.println(e1.equals(e2));
        System.out.println(e1==e2);
    }
}
