package code;

import java.util.HashMap;
import java.util.Map;

public class SrtingRolling {

    public static void main(String[] args) {
        String input = "56JM78PPMPD192";
        System.out.println("input string - " + input);
        Integer nos = Integer.parseInt(input.replaceAll("[a-z/A-Z]", ""));
        System.out.println("Only numbers from string - " + nos);

        String onlyChars = input.replaceAll("[0-9]", "");
        System.out.println("Without nos -" + onlyChars);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < onlyChars.length(); i++) {
            char ch = onlyChars.charAt(i);
            builder.append(++ch);
        }
        String rolling = builder.toString();
        System.out.println("Rolling - " + rolling);
        Map<Character, Integer> map = new HashMap<>();
        char current = rolling.charAt(0);
        for (int i = 1; i < rolling.length(); i++) {
            char ch = rolling.charAt(i);
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else
                map.put(ch, 1);
        }
        map.entrySet().stream().filter(values -> values.getValue() > 1)
                .forEach(vl -> System.out.println(vl.getKey() + " - " + (vl.getValue())));
    }
}

