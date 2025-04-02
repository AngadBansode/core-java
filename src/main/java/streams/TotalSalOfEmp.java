package streams;

import model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// total sal of emp in desc order, one emp can be worked on multiple departments,
// so total sal is sum of all department sal
public class TotalSalOfEmp {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "IT", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 32, "Male", "Infrastructure", 2010, 27000.0));
        employeeList.add(new Employee(245, "Seema Kale", 25, "Male", "Product Development", 2017, 21000.0));
        employeeList.add(new Employee(245, "Paul Niksui", 25, "Male", "Product Development", 2017, 21000.0));
        employeeList.add(new Employee(245, "Nima Roy", 25, "Male", "Product Development", 2017, 21000.0));
        employeeList.add(new Employee(245, "Seema Kale", 25, "Male", "HR", 2017, 21000.0));

        // 1. way
        var collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName,
                        Collectors.collectingAndThen(Collectors.summarizingDouble(Employee::getSalary), DoubleSummaryStatistics::getSum)))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
          System.out.println(collect);
        // 2. way
        var linkedHashMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.summingDouble(Employee::getSalary)))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(linkedHashMap);

    }

}
