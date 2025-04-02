package streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.Employee;

import java.util.*;
import java.util.stream.Collectors;

// find the max avg of student marks
public class FindTheMaxAverage {

    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("Angad", 90d),
                new Student("Angad", 70d),
                new Student("Eric", 70d),
                new Student("Rekha", 45d));
        Double maxAvgOfStudentMarks = findTheMaxAvgOfStudentMarks(students);
        System.out.println(maxAvgOfStudentMarks);
    }

    private static Double findTheMaxAvgOfStudentMarks(List<Student> students) {
        Comparator<Student> byAveMax = Comparator.comparingDouble(Student::getMarks).reversed();

         var result= students.stream()
                .parallel()
                .collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getMarks)))
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .get();
//        System.out.println(result.getKey());

        // sort the

    /*    students.stream()
                .parallel()
                .collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getMarks)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue().reversed())
                .forEach(System.out::println);*/



        return result.getValue();


    }

}

@AllArgsConstructor
@Data
class Student {
    String name;
    Double marks;
}
