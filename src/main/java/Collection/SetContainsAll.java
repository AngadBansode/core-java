package Collection;

import java.util.*;

public class SetContainsAll {

    public static void main(String[] args) {

        Set<Character> characterSet = new HashSet<>();
            characterSet.add('a');
            characterSet.add('b');
            characterSet.add('c');
            characterSet.add('d');
        Set<Character> anotherSet = new HashSet<>();
        anotherSet.add('a');
        anotherSet.add('b');
        anotherSet.add('c');

        System.out.println(anotherSet.containsAll(characterSet));
    }
}
