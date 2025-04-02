package employee;

import model.Employee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EmpAsKeyMap {

    public static void main(String[] args) {
        Map<Employee, String> empMap = new TreeMap<>(Comparator.comparing(Employee::getId));

        empMap.put(new Employee(101, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0), "HR");
        empMap.put(new Employee(102, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0), "Sales");
        empMap.put(new Employee(103, "Pooja Patil", 29, "Female", "IT", 2019, 15000.0), "IT");
        empMap.put(new Employee(104, "Raj Kanth", 32, "Male", "COMP", 2024, 25000.0), "COMP");

        System.out.println(empMap.size());

        System.out.println(empMap);

        //1. without using java 8 sort by age asc then sal desc
    }
}
