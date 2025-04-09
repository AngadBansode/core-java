import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class Employee {


    private int id;
    private String name;
    private double salary;
    private List<String> projects;
    private Department department;
    private Map<Integer, Double> yearlySalaries;

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 85000, Arrays.asList("ProjectA", "ProjectB"),
                        new Department("Engineering"),
                        Map.of(2021, 80000.0, 2022, 85000.0)),
                new Employee(2, "Bob", 90000, Arrays.asList("ProjectA"),
                        new Department("HR"),
                        Map.of(2021, 88000.0, 2022, 90000.0)),
                new Employee(3, "Charlie", 120000, Arrays.asList("ProjectB", "ProjectC","ProjectD"),
                        new Department("Engineering"),
                        Map.of(2021, 110000.0, 2022, 120000.0)),
                new Employee(4, "David", 75000, Arrays.asList("ProjectC"),
                        new Department("Finance"),
                        Map.of(2021, 72000.0, 2022, 75000.0))
        );

        //// 1. Find employees working on the most projects
         var empProCount=   employees.stream()
                    .collect(Collectors.toMap(Employee::getName, proCount -> proCount.getProjects().size()))
                 .entrySet().stream().max(Map.Entry.comparingByValue());
        System.out.println(empProCount);

        //// 2. Group employees by department and find the highest earner in each department
/*      var result=  employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

             result.entrySet()
                     .stream()
                     .collect(Collectors.groupingBy(name -> name.getValue().stream().map(Employee::getName),Employee::getSalary ));
             */
        //// 3. Flatten all unique projects employees are working on
      var uniqueProjects =  employees.stream()
                .flatMap(projects -> projects.getProjects().stream())
                .distinct()
                .toList();
        System.out.println(uniqueProjects);
        //// 7. Sort employees by department, then salary in descending order

        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5,5};
          // Map<Integer, Counting>

       var result = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);


    }
}


class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


interface Worker {
    void work();

}
interface eatable{
    void eat();
}
class Robot implements Worker {
    public void work() {
        System.out.println("Robot working...");
    }


}
class Human implements eatable, Worker{
    public void work() {
        System.out.println("Robot working...");
    }

    public void eat(){

    }

}