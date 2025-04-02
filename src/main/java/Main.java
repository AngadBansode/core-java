import java.util.*;

class Student {
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

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
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
}

public class Main {
    public static void main(String[] args) {
        // TreeSet with a comparator that sorts by name but ensures uniqueness by ID
        TreeSet<Student> studentSet = new TreeSet<>(Comparator
                .comparing(Student::getName));

        // Adding students
        studentSet.add(new Student("Alice", 101));
        studentSet.add(new Student("Bob", 102));
        studentSet.add(new Student("Charlie", 103));
        studentSet.add(new Student("Alice", 104)); // Same name, different ID
        studentSet.add(new Student("Eve", 101));   // Different name, same ID

        // Printing size of the set
        System.out.println("Size of the set: " + studentSet.size());

        // Printing students
        for (Student student : studentSet) {
            System.out.println(student);
        }
    }
}
