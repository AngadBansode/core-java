package java8.interfaces;

public interface Calculation<T extends Number> {

    static long sumDemo(long n1, long n2){
        return n1+n2;
    }

    default T doCaculation(T n1, T n2){
        Double add = n1.doubleValue()+n2.doubleValue();
        return (T) add;
    }
}
