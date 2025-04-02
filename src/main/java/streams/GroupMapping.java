package streams;
/*ConcurrentMap<City, Set<String>> namesByCity  = people.stream().collect(groupingByConcurrent(Person::getCity,
        mapping(Person::getLastName,
        toSet())));*/


import org.example.Employee;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;

public class GroupMapping {

    public static void main(String[] args) {

        Employee employee = new Employee("John",23,"IT",123.21);
        Employee employee1 = new Employee("Ram",34,"IT",321.12);
        Employee employee2 = new Employee("Ravi",23,"COMP",1233.21);
        Employee employee3 = new Employee("John",23,"IT",1233.21);

        List<Employee> employees = List.of(employee,employee1,employee2,employee3);

       var emp = employees.stream().collect(groupingBy(Employee::getDepartment,
                        mapping(Employee::getName, toSet())));

        System.out.println(emp);


//        employee.getEmployees().stream().collect(groupingBy(Employee::getDepartment,
//                mapping(Employee::getFirstName, toSet())));
    }
}
