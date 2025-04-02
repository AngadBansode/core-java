package streams;

import org.example.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmpStreamsDemo {
    static List<Employee> employees = new ArrayList<>();
     static {
         // create a list of employees

          // add 10 emp to this list
          employees.add(new Employee(12, "John", 23, "M", "IT", 2011, 25000));
            employees.add(new Employee(13, "Raj", 23, "F", "EXTC", 2012, 25000));
            employees.add(new Employee(14, "Mike", 33, "M", "IT", 2011, 23000));
            employees.add(new Employee(15, "Sara", 23, "M", "Chemical", 2011, 25000));
            employees.add(new Employee(16, "David", 23, "F", "IT", 2013, 25000));
            employees.add(new Employee(17, "Smith", 23, "M", "COMP", 2011, 25000));
            employees.add(new Employee(18, "Sam", 53, "M", "IT", 2011, 24000));
            employees.add(new Employee(19, "Sara", 26, "F", "IT", 2015, 15000));
            employees.add(new Employee(20, "David", 23, "M", "CIVIL", 2011, 25000));
            employees.add(new Employee(21, "Smith", 29, "F", "IT", 2019, 29000));

     }
    public static void main(String[] args) {
         // map of emp by gender count
            employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
                    .forEach((k,v)-> System.out.println(k+" "+v));
       // map of emp by gender and their names
        employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())))
                .forEach((k,v)-> System.out.println(k+" "+v));

        // Stream.of method use for employee
        List<String> names = Stream.of(employees).flatMap(List::stream).map(Employee::getName).toList();
           System.out.println(names);

            Stream.of(1,2,3,4,5).mapMulti((value, consumer) -> {
                if (value % 2 == 0) {
                    consumer.accept(value);
                }
            }).forEach(System.out::println);

        // Stream of int values and do sum
        int sum = Stream.of(1,2,3,4,5).reduce(0, Integer::sum);
        System.out.println(sum);

         // peek method use on employee list
        System.out.println("Peek ----------------------");
        employees.stream().peek(e->e.setSalary(e.getSalary()+1000)).forEach(System.out::println);
    }
}
