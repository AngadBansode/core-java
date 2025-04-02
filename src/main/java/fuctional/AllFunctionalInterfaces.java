package fuctional;

import java.util.function.*;

public class AllFunctionalInterfaces {

    public static void main(String[] args) {

        //1. Consumer -- accept one arg and void return
        Consumer<String> consumer = str -> System.out.println("Hello, " + str);
        consumer.accept("World"); // Output: Hello, World

        //2.Supplier<T> -- Nothing take but return one
        Supplier<String> supplier = () -> "Hello, Supplier!";
        System.out.println(supplier.get()); // Output: Hello, Supplier!

        //3. Function<T, R> - take T and return R

        Function<Integer, String> function = num -> "Number: " + num;
        System.out.println(function.apply(5)); // Output: Number: 5

        //4. IntFunction -- take int arg and return R
        IntFunction<String> intFunction = num ->  "Number: " + num;
        System.out.println(intFunction.apply(5)); // Output: Number: 5

        //5. Predicate<T> --  take T & return boolean
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(4)); // Output: true
        System.out.println(isEven.test(5)); // Output: false

        // 6.IntPredicate<Integer> more specialised Functional Interface 'IntPredicate'
        IntPredicate isEvenInt = num -> num % 2 == 0;
        System.out.println(isEvenInt.test(4)); // Output: true
        System.out.println(isEvenInt.test(5)); // Output: false
       // 7.  DoublePredicate
        DoublePredicate doublePredicate = num -> num % 2 == 0;
        System.out.println(doublePredicate.test(4.5)); // Output: false
        System.out.println(doublePredicate.test(5.5)); // Output: false

       // 8. BiConsumer<T, U> -- accepts two inputs and returns no result.
        BiConsumer<String, Integer> biConsumer = (name, age) ->
                System.out.println(name + " is " + age + " years old.");
        biConsumer.accept("Alice", 30); // Output: Alice is 30 years old.

        //9.  BiFunction<T, U, R> - R apply(T t, U u)- accepts two arguments and produces a result.
        BiFunction<Integer, Integer, String> adder = (a, b) -> "Sum: " + (a + b);
        System.out.println(adder.apply(3, 4)); // Output: Sum: 7

        // 10.BiPredicate<T, U> - boolean test(T t, U u) -  predicate (boolean-valued function) of two arguments.
            BiPredicate<String, String> isEqual = (a, b) -> a.equalsIgnoreCase(b);
            System.out.println(isEqual.test("java", "JAVA")); // Output: true

       //11. UnaryOperator<T> --T apply(T t) --
        // A specialized Function<T, T> that takes an argument and returns a result of the same type.
            UnaryOperator<Integer> square = num -> num * num;
            System.out.println(square.apply(5)); // Output: 25
        System.out.println("Identity: " + UnaryOperator.identity());

        //12. BinaryOperator<T> - T apply(T t1, T t2)

            BinaryOperator<Integer> multiply = (a, b) -> a * b;
            System.out.println(multiply.apply(3, 4)); // Output: 12



    }

}
