package employee;

import model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmpMain {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 25000.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Manu", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu", 35, "Male", "Infrastructure", 2010, 27000.0));
        employeeList.add(new Employee(245, "Seema Kale", 25, "Male", "Product Development", 2017, 21000.0));

        // 1. max sal by each department and sal in desc order
        /*employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> {
                    if (o1.get().getSalary() == o2.get().getSalary())
                        return 0;
                    else if (o2.get().getSalary() > o1.get().getSalary())
                        return 1;
                    else return -1;
                }))
                .forEach(System.out::println);
*/
        sortMapByAgeThenSalary();

    }

    private static void sortMapByAgeThenSalary() {

        Map<Integer, Employee> empMap = new HashMap<>();
        empMap.put(101, new Employee(101, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        empMap.put(102, new Employee(102, "Ravi Kale", 24, "Male", "HR", 2010, 35000.0));
        empMap.put(103, new Employee(103, "Pooja Patil", 29, "Female", "IT", 2019, 15000.0));
        empMap.put(104, new Employee(104, "Raj Kanth", 32, "Male", "COMP", 2024, 33000.0));
        //1. approach
        var result = empMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> {
                    if (o1.getAge() == o2.getAge())
                        return o2.getSalary() > o1.getSalary() ? 1 : -1;
                    else if (o1.getAge() > o2.getAge())
                        return 1;
                    else
                        return -1;
                }))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    //        System.out.println(result);

        //2. approach

        // Sort by age (ascending) and then by salary (descending)
        LinkedHashMap<Integer, Employee> sortedMap = empMap.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    Employee emp1 = e1.getValue();
                    Employee emp2 = e2.getValue();
                    int ageComparison = Integer.compare(emp1.getAge(), emp2.getAge());
                    if (ageComparison == 0) {
                        return Double.compare(emp2.getSalary(), emp1.getSalary()); // Descending salary
                    }
                    return ageComparison; // Ascending age
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        // Print the sorted map
        sortedMap.forEach((key, value) -> System.out.println(key + " -> " + value));

        // 3. without using java 8 streams how to sort it

                // Convert the map to a list of entries
                List<Map.Entry<Integer, Employee>> entryList = new ArrayList<>(empMap.entrySet());

                // Sort the list by age (ascending) and salary (descending)
                Collections.sort(entryList, new Comparator<Map.Entry<Integer, Employee>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Employee> e1, Map.Entry<Integer, Employee> e2) {
                        Employee emp1 = e1.getValue();
                        Employee emp2 = e2.getValue();
                        int ageComparison = Integer.compare(emp1.getAge(), emp2.getId());
                        if (ageComparison == 0) {
                            return Double.compare(emp2.getSalary(), emp1.getSalary()); // Descending salary
                        }
                        return ageComparison; // Ascending age
                    }
                });

        System.out.println("After sorting map: " + entryList);

                // Insert sorted entries into a LinkedHashMap
                Map<Integer, Employee> sortedLinkedhashMap = new LinkedHashMap<>();
                for (Map.Entry<Integer, Employee> entry : entryList) {
                    sortedLinkedhashMap.put(entry.getKey(), entry.getValue());
                }

                // Print the sorted map
                for (Map.Entry<Integer, Employee> entry : sortedLinkedhashMap.entrySet()) {
                    System.out.println(entry.getKey() + " -> " + entry.getValue());
                }
            }
}
