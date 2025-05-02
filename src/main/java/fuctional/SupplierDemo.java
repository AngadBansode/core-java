package fuctional;

import java.util.Locale;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierDemo<T,U> {


    public static void main(String[] args) {
        Supplier supplierDemo = () ->  "supply";
        System.out.println("Supplier: " + supplierDemo.get());
        Supplier<String> supplier = "name"::toUpperCase;
        System.out.println(supplier.get());

        Consumer<String> stringConsumer = name -> System.out.println(name.toLowerCase(Locale.ROOT));
         stringConsumer.accept("AnGad")  ;




    }
}
