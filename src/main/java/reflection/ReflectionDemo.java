package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        @SuppressWarnings("unused")
        Cat cat = new Cat("Sweety", 6);

//1. Fields all...private, public default...
        Field [] declaredFields = cat.getClass().getDeclaredFields();

        for(Field field: declaredFields) {
            System.out.println(field.getName());
            if (field.getName().equalsIgnoreCase("name")) {
                field.setAccessible(true);// if false - IllegalAccessException
                field.set(cat, "New Cat");//IllegalAccessException
            }
        }
 //2. methods... all...private, public default...

        Method[] methods =  cat.getClass().getDeclaredMethods();
        for(Method method : methods) {
//            System.out.println("Mehtods: " + method.getName());
        if(method.getName().equals("privateStaticMethod")){
            method.setAccessible(true);
            method.invoke(null, "myBlackCat");
        }
        }
    }
}
