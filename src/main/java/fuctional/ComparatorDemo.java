package fuctional;

import model.Employee;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Employee sorting based on multiple fields
public class ComparatorDemo {


    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Manu", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu", 35, "Male", "Infrastructure", 2010, 27000.0));
        employeeList.add(new Employee(245, "Seema Kale", 25, "Male", "Product Development", 2017, 21000.0));


    //1. sort by name in asc order

       /* Comparator<Employee> byName = Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary);

        Collections.sort(employeeList,byName.reversed());
        System.out.println(employeeList);*/

    // using stream api first by name and then sal in desc order

        var employeeList1 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName).thenComparingDouble(Employee::getSalary).reversed() ).toList();
//        System.out.println(employeeList1);

        //

        //1. by name in asc order

        Comparator<Employee> byName = Comparator.comparing(Employee::getName);

        // 2 if name is same then sal by desc order
        Comparator<Employee> bySalDesc = (e1,e2) -> e2.getSalary() > e1.getSalary() ? 1: -1;

        Comparator<Employee> byNameAndSalDesc = byName.thenComparing(bySalDesc);

        employeeList.stream().sorted(byNameAndSalDesc).forEach(System.out::println);

    }
}
