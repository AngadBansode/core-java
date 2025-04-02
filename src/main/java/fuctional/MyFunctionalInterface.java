package fuctional;
@FunctionalInterface
public interface MyFunctionalInterface {

    void print();

    @Override
    boolean equals(Object obj);

    default void display(String message){
        System.out.println("printing message from default:" + message);
    }
}
