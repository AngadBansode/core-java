package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingDouble;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Employee c1= new Employee("Angad",25);
        Employee c2= new Employee("Angad",25);
        Set<Employee> employeeSet=new HashSet<>();

        employeeSet.add(c1);
        employeeSet.add(c2);

        System.out.println(employeeSet.size());//1

        // EmployeeManager using lambda exp
        EmployeeManager employeeManager =  () -> new Employee(123, "John", 23, "M", "IT", 2011, 25000);

        var name = employeeManager.getEmployee().getName();
        System.out.println("Name: " + name);


        // default ctor
        EmployeeManager employeeManager1 = Employee::new;
        var name1 = employeeManager1.getEmployee().getName();
        System.out.println("Name: " + name1);// null

        // check method reference
        Employee e1= new Employee("Angad",25);
        Employee e2= new Employee("Angad",25);
        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);

        var collectNames = employeeList.stream()
                .peek(employee -> employee.setDepartment("IT"))
                .toList();
        System.out.println(collectNames);//[Angad]


    }
}
