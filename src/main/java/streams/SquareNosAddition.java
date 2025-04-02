package streams;

import java.util.*;

public class SquareNosAddition {

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9); // 1 + 4 + 9 + = 14

        int add = findTheSquareNosAddition(list);
        System.out.println(add);

    }

    private static int findTheSquareNosAddition(List<Integer> list) {

        return list.stream()
                .filter(ele -> list.contains(ele * ele))
                .map(sq -> sq * sq).reduce(0, Integer::sum);


    }
}
