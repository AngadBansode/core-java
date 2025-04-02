package java8.interfaces;

public class CalculationImpl implements Calculation<Number> {
    public static void main(String[] args) {

        CalculationImpl  number = new CalculationImpl();

        System.out.println(number.doCaculation(25 ,25));
        System.out.println(Calculation.sumDemo(10,255));

    }
}
