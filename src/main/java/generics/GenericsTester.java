package generics;

import javax.lang.model.type.ReferenceType;

public class GenericsTester {

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<>();

        //compiler errror
        //ReferenceType
        //- Syntax error, insert "Dimensions" to complete
//        ReferenceType
        //Box<int> stringBox = new Box<int>();

        integerBox.add(10);
        stringBox.add("Angad");
        printBox(integerBox);
        printBox(stringBox);
    }

    private static void printBox(Box box) {
        System.out.println("Value: " + box.get());
    }
}

class Box<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
