package fuctional;

public class PredicateTestImpl<Object> implements PredicateTest<Object>{

    @Override
    public boolean test(Object object) {
        return object.equals("true") ? true: false;
    }

    public static void main(String[] args) {
          PredicateTest<java.lang.String> test = new PredicateTestImpl<>();
        System.out.println(test.test("KLMP"));
    }
}
