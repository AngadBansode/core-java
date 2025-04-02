package code;


import org.example.Employee;
        import streams.User;

        import java.lang.reflect.Array;
        import java.util.ArrayList;
        import java.util.*;
        import java.util.HashMap;
        import java.util.LinkedHashSet;
        import java.util.List;
        import java.util.Map;
        import java.util.concurrent.atomic.AtomicInteger;
        import java.util.function.BinaryOperator;
        import java.util.function.Function;
        import java.util.function.Predicate;
        import java.util.stream.Collectors;
        import java.util.stream.IntStream;
        import java.util.stream.Stream;

        import static java.util.Comparator.comparingDouble;
        import static java.util.Comparator.comparingInt;
        import static java.util.stream.Collectors.collectingAndThen;
        import static java.util.stream.Collectors.counting;
        import static java.util.stream.Collectors.groupingBy;
        import static java.util.stream.Collectors.maxBy;
        import static java.util.stream.Collectors.toList;

public class EPAMInterview {


    /* Unsorted array  find the min elemts (sub-array) whose sum is greater than given no
     int arr [] = {12 ,2,11,45,65, 4, 10};
     int given = 90;
     return count of elements
     output -- 2*/
        /*int arr[] = {12, 70,21, 40, 5, 6, 4, 10,45};
        int given = 90;
        int sum = 0, cnt = 0, min = 0;
        List<Integer> minVal = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (sum > given) {
                sum = 0;
                minVal.add(cnt);
                cnt = 0;
                i-=1;
            } else {
                cnt++;
                sum = sum + arr[i];
            }

        }
        int minEle = minVal.stream()
                .min(Integer::compare)
                .orElse(Integer.MIN_VALUE); // Default value if list is empty
//        OptionalInt minElement = OptionalInt.of(minVal.stream().mapToInt(minVal::get).min().orElse(0));
//        System.out.println("Optional: " + minElement.getAsInt());
        System.out.println("Minimum element: " + minEle);*/
  /*  public static List<List<Integer>> getConsecutiveSumList(int[] a, int N) {
        List<List<Integer>> result = new ArrayList<>();
        int left = 0, right = 0, currSum = 0;
        while (right < a.length) {
            if (currSum < N) {
                currSum += a[right];
                right++;
            } else if (currSum > N) {
                currSum -= a[left];
                left++;
            }
            if (currSum == N) {
                result.add(getSubList(a, left, right));
                currSum -= a[left];
                left++;
            }
        }

        return result;
    }

    private static List<Integer> getSubList(int[] a, int left, int right) {
        List<Integer> subList = new ArrayList<>();
        for (int i = left; i < right; i++) {
            subList.add(a[i]);
        }
        return subList;
    }

    public static void main(String[] args) {
        int[] a = {11, 7, 5, 1, 3, 32, 8, 5, 12};
        int N = 13;
        System.out.println(getConsecutiveSumList(a, N));
    }*/


        public static void main(String[] args) {
            int arr[] = { 11, 2, 2, 2, 2, 9, 4, 15, 8, 8 ,1};
            Map<Integer, int[]> indexMap = new HashMap<>();

            for(int i = 0; i < arr.length; i++) {
                int n = arr[i];
                int[] index = indexMap.getOrDefault(n, new int[]{-1, -1});
                if(index[0] == -1) {
                    index[0] = i;
                }
                index[1] = i;
                indexMap.put(n, index);
            }
            System.out.println("First and Last index of distinct elements are : ");
            indexMap.entrySet().stream().filter(entry -> entry.getValue()[0] != entry.getValue()[1])
                    .forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()[0] + "," + entry.getValue()[1] + ":" ));



}

}
