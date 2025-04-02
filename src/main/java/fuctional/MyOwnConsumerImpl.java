package fuctional;

import java.util.Locale;

public class MyOwnConsumerImpl implements MyOwnConsumer<String,String>{


    @Override
    public String acceptArgumentsAndReturn(String s) {
        return s.toUpperCase(Locale.ROOT);
    }

    public static void main(String[] args) {

        MyOwnConsumerImpl myOwnConsumer = new MyOwnConsumerImpl();

        System.out.println( myOwnConsumer.acceptArgumentsAndReturn("Hello"));

        myOwnConsumer.myConsumerDefaultPrint("Angad");
    }
}
