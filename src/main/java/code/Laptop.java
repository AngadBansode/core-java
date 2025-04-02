package code;

import org.example.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Laptop {
//    public abstract void run();

    public static void main(String[] args) {
        // create emp list and some dummy employee
       Employee emp1 = new Employee("John", 25, "IT",1000);
       Employee emp2 = new Employee("Jane", 30, "HR",2000);
       Employee emp3 = new Employee("Mike", 35, "Finance", 3000);
       Employee emp4 = new Employee("Sarah", 28, "IT",4000);
       Employee emp5 = new Employee("David", 32, "HR",5000);
       Employee emp6 = new Employee("Emily", 27, "Finance",6000);
       Employee emp7 = new Employee("James", 31, "IT",7000);
       Employee emp8 = new Employee("Sophia", 29, "Health",8000);

       // create list of employees
       List<Employee> empList = new ArrayList<>();
       empList.add(emp1);
       empList.add(emp2);
       empList.add(emp3);
       empList.add(emp4);
       empList.add(emp5);
       empList.add(emp6);
       empList.add(emp7);
       empList.add(emp8);

       // find the average salary by department
//       empList.stream()
//              .collect(Collectors.groupingBy(Employee::getDepartment))
//              .forEach((department, employees) -> {
//                  double averageSalary = employees.stream()
//                                                  .mapToDouble(Employee::getSalary)
//                                                  .average()
//                                                  .orElse(0);
//                  System.out.println("Average salary for " + department + " is " + averageSalary);
//
//              });

        Map<String,Double> avgByDeptName =  empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
       System.out.println("Emp: " + avgByDeptName);

       Map<String,List<String>> map =   empList.parallelStream()

               .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));


       System.out.println("Emp by DeptName: " + map);

    }
}
