package streams;

import model.Employee;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsFlatMap {
    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
        var output = list.stream()
                .collect(Collectors.flatMapping(Collection::stream, Collectors.toList()));
//        System.out.println(output);

        // create Map of String and List<Employee>
        Map<String, List<Employee>> map = new HashMap<>();
        map.put("IT", Arrays.asList(new Employee(101, "Angad", "IT", 1101),
                new Employee(102, "Amit", "IT", 25000)));
        map.put("COMP", Arrays.asList(new Employee(101, "Dwija", "COMP", 1101),
                new Employee(102, "Ravi", "COMP", 25000),
                new Employee(103, "Shankar", "COMP", 25000)));
        map.put("CIVIL", Arrays.asList(new Employee(101, "Raj", "CIVIL", 23000),
                new Employee(102, "Yash", "CIVIL", 17000),
                new Employee(103, "Pooja", "CIVIL", 17000)));

        var mapOutput = map.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, value -> value.getValue().stream()
                        .collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(emp -> emp, Collectors.toList())))
                        .entrySet().stream().filter(val -> val.getValue().size() > 1).toList()));

        System.out.println(mapOutput);

    }
}
