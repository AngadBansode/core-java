import org.example.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainIssue {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
          integers.add(123);
          integers.add(456);
          integers.add(789);
          integers.add(101);

        ScheduledIssue scheduledIssue = new ScheduledIssue();

        integers.forEach(scheduledIssue::addIssueId);
        System.out.println(scheduledIssue.getIssueIds());


        List<Employee> emp = new ArrayList<>();
          emp.add(new Employee("John", 30));
          emp.add(new Employee("Jane", 25));
          emp.add(new Employee("Bob", 35));


      Map<Employee,Boolean> map =  emp.stream().collect(Collectors.toMap(employee -> employee, employee -> true));
        System.out.println(map);

    }

}
