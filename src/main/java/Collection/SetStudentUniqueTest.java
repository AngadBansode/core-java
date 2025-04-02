package Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.Employee;

import java.util.*;

public class SetStudentUniqueTest {

    public static void main(String[] args) {
        TreeSet<Employee> employees = new TreeSet<>(Comparator.comparing(Employee::getName));
        employees.add(new Employee(2, "Bob", "bob@yahoo.com"));
        employees.add(new Employee(1, "Alice" , "alice@gmail.com"));

        for (Employee emp : employees) {
            System.out.println(emp.getId() + " " + emp.getName());
        }


       /* TreeSet<Student> students = new TreeSet<>();

        Student s1 = new Student(1, "Ravi", "Pbn");
        Student s2 = new Student(2, "Ravi", "NED");
        Student s3 = new Student(1, "Deepa", "Hyd");

        students.add(s1);
        students.add(s2);
        students.add(s3);

        System.out.println(students.size());

        // Printing students -- sorted by name and identified by id
        for (Student student : students) {
            System.out.println(student);
        }*/
        TreeSet<Student> studentSet = new TreeSet<>();

        // Adding students
        studentSet.add(new Student("Alice", 101));
        studentSet.add(new Student("Bob", 102));
        studentSet.add(new Student("Charlie", 103));
        studentSet.add(new Student("Alice", 104)); // Same name, different ID
        studentSet.add(new Student("Eve", 101));   // Different name, same ID (will not be added)

        System.out.println(studentSet.size());
        // Printing students
        for (Student student : studentSet) {
            System.out.println(student);
        }
    }
}

@Data
//@AllArgsConstructor
class Student implements Comparable<Student> {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // compareTo ensures consistent sorting by name, then by id
    @Override
    public int compareTo(Student other) {
//        int nameComparison = this.name.compareTo(other.name);
//        if (nameComparison == 0) {
            return Integer.compare(this.id, other.id); // Break ties by ID

        //return nameComparison;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id; // Equality based on unique ID
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Hash based on unique ID
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }

}