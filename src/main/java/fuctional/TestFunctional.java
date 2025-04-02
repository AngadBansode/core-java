package fuctional;

import java.util.function.BiFunction;

public class TestFunctional {

    public static void main(String[] args) {

        BiFunction<String, String, String> biFunctionStringChehck = (s1, s2) -> {
            if (s1.equals(s2))
                return "both are equal";
            else if (s1.compareTo(s2) ==1)
                return s1 + " is greater s1";
            else
                return s2 + " is greater s2";
        };

//        System.out.println(biFunctionStringChehck.apply("RAMA", "rama"));

         MyFunctionalInterface myFunctional = () -> System.out.println("lambda exp");
           doPrint(myFunctional);


        myFunctional.display("HEllo AnNGAD");

    }

    public static void doPrint(MyFunctionalInterface myFunctionalInterface){
        myFunctionalInterface.print();
    }

}
