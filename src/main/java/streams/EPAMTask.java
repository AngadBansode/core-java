package streams;

import org.example.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EPAMTask {
    public static void main(String[] args) {
        Map<String, List<String>> maps = new HashMap<String, List<String>>();
        maps.put("Animals", Arrays.asList("Tiger","Dog","Cat","Deer","Monkey","SPARROW","Tiger","Cat")); // SPARROW
        maps.put("Fruits", Arrays.asList("apple","mango","banana","chiku")); // all ignore
        maps.put("Cities", Arrays.asList("Hyderabad","Pune","Mumbai","New York","Goa","Chennai","Pune")); // New York
  }
}
