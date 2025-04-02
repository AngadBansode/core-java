package fuctional;

public class MyFunctionalInterfaceImpl implements MyFunctionalInterface{


    @Override
    public void print() {
        System.out.println("print abs method");
    }

    @Override
    public void display(String message) {
        System.out.println("From impl: " + message);
    }

    public static void main(String[] args) {
        MyFunctionalInterfaceImpl impl = new MyFunctionalInterfaceImpl();

             impl.display("Hello Angad");

    }
}
