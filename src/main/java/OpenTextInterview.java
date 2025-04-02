import java.util.HashMap;
import java.util.*;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class OpenTextInterview {
   static  Map<String, List<String>> maps = new HashMap<>();
    public static void main(String[] args) {


        maps.put("Animals", Arrays.asList("Tiger", "Dog", "Cat", "Deer", "Monkey", "SPARROW", "Tiger", "Cat")); // SPARROW
        maps.put("Fruits", Arrays.asList("apple", "mango", "banana", "chiku")); // all ignore
        maps.put("Cities", Arrays.asList("Hyderabad", "Pune", "Mumbai", "New York", "Goa", "Chennai", "Pune")); // New York

        var lists = maps.entrySet().stream()
                .filter(notFruits -> !notFruits.getKey().equals("Fruits"))
                .map(keys -> {
                    if (keys.getKey().equals("Animals")) {
                        return keys.getValue().stream().filter(notSparrow -> !notSparrow.equals("SPARROW")).toList();
                    }
                    return keys.getValue().stream().filter(notNewYork -> !notNewYork.equals("New York"))
                            .filter(OpenTextInterview::checkFrequency)
                            .toList();
                }).flatMap(Collection::stream).toList();

        System.out.println("frequency: " + lists);
    }

    private static boolean checkFrequency(String checkFrequency) {
        return  Collections.frequency(maps.get("Cities"), checkFrequency) == 1 && checkFrequency.length() >= 4;

    }


}
 /* List<String> animalAndCities = maps.entrySet()
                .stream()
                .filter(entry->!entry.getKey().equalsIgnoreCase("Fruits"))
                .flatMap(entry->entry.getValue().stream())
                .filter(item->{
                    if(maps.get("Animals").contains(item)){
                        return !item.equalsIgnoreCase("SPARROW");
                    }
                    if(maps.get("Cities").contains(item)){
                        return item.length() >=4 && !item.equalsIgnoreCase("New York") &&
                                Collections.frequency(maps.get("Cities"), item) == 1;
                    }
                    return false;
                }).collect(Collectors.toList());*/

