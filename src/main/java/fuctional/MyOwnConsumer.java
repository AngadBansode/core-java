package fuctional;

public interface MyOwnConsumer<T,U> {

    U acceptArgumentsAndReturn(T t);

    default void  myConsumerDefaultPrint(T t){
        System.out.println("printing default method... " + t);
    }
}
