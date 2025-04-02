package streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//find the Nth highest salary of emp from Map
public class findNthHighestSalary {

    public static void main(String[] args) {
        //create Map of String, Integer
        Map<String, Integer> map = new HashMap<>();
        map.put("Ravi", 1000);
        map.put("Raj", 2000);
        map.put("Rahul", 3000);
        map.put("Ramesh", 2000);
        map.put("Rajesh", 5000);
        map.put("Rakesh", 5000);
        map.put("Rajesh", 4000);
        map.put("Rajesh", 3000);

        //find the nth highest salary
        int num = 2;

        var salaryHighest = getSalaryHighest(num,map);

        System.out.println(salaryHighest);
    }

    private static Map.Entry<Integer, List<String>> getSalaryHighest(int num,Map<String, Integer> map) {
        return map.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, List<String>>comparingByKey().reversed())
                .toList()
                .get(num-1);
    }
}
