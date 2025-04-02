package employee;

import model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmpByEmailDomain {

    public static void main(String[] args) {

        //create 10 emp by different mail

        List<Employee> employees = List.of(
                new Employee(101, "Angad", "angad@gmail.com"),
                new Employee(102, "Ravi", "ravi@outlook.com"),
                new Employee(103, "Pooja", "pooja@gmail.com"),
                new Employee(104, "Kishan", "kishan@yahoo.com"));

                 String email = "angad@gmail.com";
                   String [] result =     email.split("@");
        System.out.println("Email: " + Arrays.toString(result));

        Map<String, Long> domainCounts = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getEmail().split("@")[1], Collectors.counting()));
        System.out.println(domainCounts);


    }
}
