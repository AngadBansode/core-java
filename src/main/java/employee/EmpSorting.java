package employee;

import model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmpSorting {

    public static void main(String[] args) {
        Map<Integer, Employee> empMap = new HashMap<>();
        empMap.put(101, new Employee(101, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        empMap.put(102, new Employee(102, "Ravi Kale", 24, "Male", "HR", 2010, 35000.0));
        empMap.put(103, new Employee(103, "Pooja Patil", 29, "Female", "IT", 2019, 15000.0));
        empMap.put(104, new Employee(104, "Raj Kanth", 32, "Male", "COMP", 2024, 25000.0));

        //1. without using java 8 sort by age asc then sal desc

        // Convert the map to a list of entries
        List<Map.Entry<Integer, Employee>> entryList = new ArrayList<>(empMap.entrySet());

        // Sort the list by age (ascending) and salary (descending)
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Employee>>() {
            @Override
            public int compare(Map.Entry<Integer, Employee> e1, Map.Entry<Integer, Employee> e2) {
                Employee emp1 = e1.getValue();
                Employee emp2 = e2.getValue();
                int ageComparison = Integer.compare(emp1.getAge(), emp2.getAge());
                if (ageComparison == 0) {
                    return Double.compare(emp2.getSalary(), emp1.getSalary()); // Descending salary
                }
                return ageComparison; // Ascending age
            }
        });

//        System.out.println("After sorting map: " + entryList);

        // Insert sorted entries into a LinkedHashMap
        Map<Integer, Employee> sortedLinkedhashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Employee> entry : entryList) {
            sortedLinkedhashMap.put(entry.getKey(), entry.getValue());
        }

        // Print the sorted map
        for (Map.Entry<Integer, Employee> entry : sortedLinkedhashMap.entrySet()) {
//            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


        // 2. Multiple fields sorting
        List<Employee> employees = new ArrayList<>(empMap.values());

        // 1. create AgeComparator

        Comparator<Employee> byAgeAsc = Comparator.comparingInt(Employee::getAge);

        Comparator<Employee> bySal = Comparator.comparingDouble(Employee::getSalary).reversed();
        Comparator<Employee> byYearOfJoining = Comparator.comparingInt(Employee::getYearOfJoining);

          /*  employees.stream()
                    .sorted(byAgeAsc.thenComparing(bySal)
                            .thenComparing(byYearOfJoining)
                    ).forEach(System.out::println);*/

        Collections.sort(employees, byAgeAsc.thenComparing(bySal).thenComparing(byYearOfJoining));
        System.out.println(employees);

        // 2. sort name then sal

        // Create Comparators for Name and Salary fields respectively
//        Comparator<Employee> sortByName = (e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName());
        Comparator<Employee> sortBySalary = Comparator.comparingDouble(Employee::getSalary);

        //Sort by Name then Sort by Salary
//        employees.stream()
//                .sorted(sortByName.thenComparing(sortBySalary))
//                .forEach(e -> System.out.println(e));

        // 3. By only name

        employees.sort(Comparator.comparing(Employee::getName));
        employees.forEach(item -> System.out.println(item));

        // 4. Null values

        employees.sort(Comparator.nullsFirst(Comparator.comparing(Employee::getName)));

        // max sal by department
      var maxSalByDept =  employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
    // sort max sal in desc order
         var result = maxSalByDept.entrySet()
                          .stream()
                                  .sorted()
                                          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e2,
                                                  LinkedHashMap::new));
        System.out.println(result);


    }
}
