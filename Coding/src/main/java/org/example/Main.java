package org.example;

import functional.Substract;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        Map<String, List<String>> maps = new HashMap<String, List<String>>();

        List<String> fruits = Arrays.asList("apple","mango","banana","chiku");

        List<String> animals = Arrays.asList("Tiger","Dog","Cat","Deer","Monkey","SPARROW");

        var cities = Arrays.asList("Hyderabad","Pune","Mumbai","New York","Goa","Chennai");

        maps.put("Animals", animals); // Sparrow
        maps.put("Fruits", fruits); //ignore all
        maps.put("Cities", cities); // New York




    }
}
