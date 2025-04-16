package fuctional;

//@FunctionalInterface
public interface FunctionalInterfaceTestLambda {

    int test(int a, int b, String name);

    default int equalss(Object obj) {
        return 0;
    }

    //    String toString(String prefix);  Modified signature
    default int equals() {
        return 1;
    }
}


class ImplementFunctionalMethod {
    public static void main(String[] args) {

        FunctionalInterfaceTestLambda check = (a, b, c) -> a + b;
        System.out.println(check.test(10, 20, "Ravi"));


    }
}