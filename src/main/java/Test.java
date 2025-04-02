import org.example.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.commons.lang3.ArrayUtils.contains;

public class Test {

    public static void main(String[] args) {

        Employee employee1 = new Employee("Alex", 25);
        Employee employee2 = new Employee("Brian", 30);
        Employee employee3 = new Employee("Charles", 35);
        Employee employee4 = new Employee("David", 40);
        Employee employee5 = new Employee("Edward", 45);
        // get all emp with name uppercase
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4, employee5);

        // get List of employee with name in uppercase
        var employeeList = employees.stream()
                .peek(employee -> employee.setName(employee.getName().toUpperCase()))
                .toList();

        //        System.out.println(employeeList);
        //        printPrimeNumber(10);
        //        findNthHighestNumberFromArray();
        //         squareNumber();
//         firstChar();
        evenSum();
    }

    private static void squareNumber() {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int squareSum = Arrays.stream(arr)
                .filter(even -> even % 2 == 0)
                .map(square -> square * square)
                .reduce(0, Integer::sum);
        System.out.println("Square Sum: " + squareSum);

        long squareSum_1 = Arrays.stream(arr)
                .filter(even -> even % 2 == 0)
                .mapToLong(square -> square * square)
                .sum();
        System.out.println("Square Sum: " + squareSum);
        System.out.println("Square Sum Long: " + squareSum_1);
    }

    private static void findNthHighestNumberFromArray() {

        int arr[] = {12, 3, 4, 56, 9, 13, 23, 10};
        int N = 4;
        int k = 0;
        int[] largestArr = new int[N];
        Arrays.fill(largestArr, Integer.MIN_VALUE);

        for (int i = 0; i < N; i++) {
            int largest = Integer.MIN_VALUE; // 0
            for (int num : arr) { // 3 > 0 - true
                if (num > largest && !contains(largestArr, num)) {
                    largest = num; // 3
                }
                largestArr[i] = largest;// [12,]
            }
        }
        System.out.println("All arr : " + Arrays.toString(largestArr));
        System.out.println("3rd : " + largestArr[N - 1]);
    }

    // print prime number from 1 to 100
    public static void printPrimeNumber(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i);

            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;

            }
        }
        return true;
    }

    private static void firstChar() {
        String name = "iamindian";
        HashMap<Character, Integer> hm = new HashMap<>();
        name.chars().mapToObj(c -> (char) c).forEach(c -> hm.put(c, hm.getOrDefault(c, 0) + 1));
        char c = hm.entrySet().stream().filter(f -> f.getValue() > 1).map(m -> m.getKey()).findFirst().get();
        System.out.println(c);
    }

    private static void evenSum() {

        Stream<List<Integer>> stream = Stream.of(
                List.of(8, 3),
                List.of(7, 4) // 8 3 7 4
        );

        var sum = stream.flatMap(List::stream).filter(even -> even % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println(sum);


    }
}