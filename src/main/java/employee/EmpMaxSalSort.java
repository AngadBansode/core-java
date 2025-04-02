package employee;

import model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmpMaxSalSort {

    public static void main(String[] args) {
        Map<Integer, Employee> empMap = new HashMap<>();
        empMap.put(101, new Employee(101, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        empMap.put(102, new Employee(102, "Ravi Kale", 24, "Male", "HR", 2010, 35000.0));
        empMap.put(103, new Employee(103, "Pooja Patil", 29, "Female", "IT", 2019, 15000.0));
        empMap.put(104, new Employee(104, "Raj Kanth", 32, "Male", "COMP", 2024, 25000.0));

        List<Employee> employees = List.of(

                new Employee(101, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0),
                new Employee(102, "Ravi Kale", 24, "Male", "HR", 2010, 35000.0),
                new Employee(103, "Pooja Patil", 29, "Female", "IT", 2019, 15000.0),
                new Employee(104, "Raj Kanth", 32, "Male", "COMP", 2024, 25000.0)
        );

        var result = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        var max = result.entrySet()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue().get().getSalary(), e1.getValue().get().getSalary()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        System.out.println(max);


        Stream<String> stream =  Stream.of("a", "b", "c", "b")
                .filter(element -> element.contains("b"));

        List<String> anyElement = stream.collect(Collectors.toList());
        System.out.println("anyElement: " + anyElement.get(0));

        Optional<String> firstElement = stream.findFirst();
        System.out.println("firstElement: " + firstElement.get());
    }
}
