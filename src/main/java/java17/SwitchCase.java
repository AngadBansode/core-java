package java17;
/*These improvements make the switch statement more powerful and easier to use,
 reducing boilerplate code and improving code clarity.*/

import newfeatures.sealed.Circle;

public class SwitchCase {


    public static void main(String[] args) {

        //1. Switch Expressions
        int value =  2;
        int result = switch (value) {
            case 1 -> 10;
            case 2 -> 20;
            default -> 0;
        };
        System.out.println(result);

       //2.Arrow Syntax
        switch (value) {
            case 1 -> System.out.println("One");
            case 2 -> System.out.println("Two");
            default -> System.out.println("Default");
        }

        //3.Multiple Case Labels
        //Multiple case labels can be combined into a single case using commas
        switch (value) {
            case 1, 2, 3 -> System.out.println("One, Two, or Three");
            default -> System.out.println("Other");
        }
        char letter = 'I';
        String category = switch (letter) {
            case 'A', 'E', 'I', 'O', 'U' -> "Vowel";
            case 'B', 'C', 'D', 'F', 'G' -> "Consonant";
            default -> "Other";
        };
        System.out.println("Letter: " + category);

        //4.Yield Keyword
        //When a case contains a block of code,
        // the yield keyword is used to return a value from the switch expression.
        int result2 = switch (value) {
            case 1 -> {
                System.out.println("Processing one");
                yield 10;
            }
            case 2 -> {
                System.out.println("Processing two");
                yield 20;
            }
            default -> 0;
        };
        System.out.println(result2);

    // 6. Exhaustiveness Checking - For sealed types and enums, the compiler ensures that all possible cases are handled.
      // This helps catch errors at compile time.

    }

   /* public String describeShape(Shape shape) {
        return switch (shape) {
            case Circle2 c -> "This is a circle";
            case Rectangle r -> "This is a rectangle";
        };
    }*/

}

sealed interface Shape permits Circle2, Rectangle {}
final class Circle2 implements Shape {}
final class Rectangle implements Shape {}


