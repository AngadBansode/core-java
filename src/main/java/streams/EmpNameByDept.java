package streams;

import org.example.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmpNameByDept {

    public static void main(String[] args) {

         List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("John", 25, "IT",1000));
        empList.add(new Employee("Mike", 35, "HR",2000));
        empList.add(new Employee("Sam", 45, "Finance",3000));
        empList.add(new Employee("Tom", 55, "Finance",4000));
        empList.add(new Employee("Harry", 65, "IT",5000));
        empList.add(new Employee("Ron", 75, "Finance",6000));
        empList.add(new Employee("Hermione", 85, "HR",7000));
        empList.add(new Employee("Draco", 95, "IT",8000));
        empList.add(new Employee("Neville", 105, "Finance",9000));
        empList.add(new Employee("Luna", 115, "HR",10000));

        // get employee names by department
//        empList.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment))
//                .forEach((dept, emp) -> System.out.println(dept + ": " + emp.stream().map(Employee::getName).collect(Collectors.joining(", "))));
//

       var emp = empList.stream().parallel()
                 .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));

        System.out.println(emp);
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        int max =  myList.stream()
                .max(Integer::compare)
                .get();
        System.out.println(max);



        /* or we can try using below way */
   int arr []  ={12,34,1,3,2,0,43};
        int maxdata = Arrays.stream(arr).boxed()
                .max(Comparator.naturalOrder()).get();

        System.out.println(maxdata);

    }
}
