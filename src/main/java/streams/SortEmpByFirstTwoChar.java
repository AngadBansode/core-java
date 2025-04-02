package streams;

import model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmpByFirstTwoChar {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 32, "Male", "Infrastructure", 2010, 27000.0));
        employeeList.add(new Employee(245, "Seema Kale", 25, "Male", "Product Development", 2017, 21000.0));

        // sort emp by first two char of name
        employeeList.stream()
                .sorted((e1, e2) -> e1.getName().substring(0, 2).compareTo(e2.getName().substring(0, 2)))
                .forEach(System.out::println);

        employeeList.stream()
                .sorted(Comparator.comparing(e -> e.getName().substring(0, 2)))
                .forEach(System.out::println);

        // reversed order-desc

        Comparator<Employee> nameComparator = Comparator.comparing(e -> e.getName().substring(0, 2));
        Comparator<Employee> ageComparator = (o1, o2) -> {
            if (o1.getAge() > o2.getAge()) {
                return -1;
            } else if (o1.getAge() < o2.getAge())
                return 1;
            else
                return 0;
        };


        List<Employee> sortedList = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).reversed()).toList();

        sortedList.forEach(System.out::println);

        // emp by sal desc
        List<Employee> sortedBySalaryDesc = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        System.out.println(sortedBySalaryDesc);

       // sort emp by age if age is same then sal in desc order
        List<Employee> sortedByAgeAndSalary = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).thenComparingDouble(Employee::getSalary).reversed())
                .toList();
        System.out.println("SalNAge: " + sortedByAgeAndSalary);

        // sort emp by age in asc order if age is same then sal in desc order

        Comparator<Employee> salCompDesc = (e1,e2) -> e1.compare(e1,e2);

        List<Employee> sortedByNameAndSalaryDesc = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName)
                        .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed()))
                .collect(Collectors.toList());
    }
}
