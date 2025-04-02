package innerclass;

public class RunInnerClass {

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();

        //create inner class instance and call method
        outerClass.new InnerClass().printOuterClassVariables();

        // call static inner class method
        OuterClass.StaticInnerClass.printStaticInnerClassVariables();

        // call createInnerClassInsideMethod()
        outerClass.createInnerClassInsideMethod();

    }
}
