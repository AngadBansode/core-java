package innerclass;

public class OuterClass {

    private static int x = 10;
    private String name = "OuterClass";

    //create inner class
    class InnerClass {
        private static int y = 20;

        //print outclass variables
        public void printOuterClassVariables() {
            System.out.println("OuterClass x: " + x);
            System.out.println("OuterClass name: " + name);
            System.out.println("Inner class Y: " + y);

        }
    }

    //create static inner-class
    static class StaticInnerClass {
        private static int z = 30;

        public static void printStaticInnerClassVariables() {
            System.out.println("Static Inner class Z: " + z);
            System.out.println("Outer class X:" + x);
        }
    }

    // create member inner class
    public interface InnerInterface {
        void printInnerInterfaceVariables();

    }

    public static void main(String[] args) {
        // create object of inner class
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.printOuterClassVariables();
    }

    //create inner class inside method--localclass
    public static void createInnerClassInsideMethod() {

          class InnerClassInsideMethod {
            private int p = 24;

            public void printInnerClassInsideMethodVariables() {
                System.out.println("Inner class inside method p: " + p);
            }
        }
        InnerClassInsideMethod innerClassInsideMethod = new InnerClassInsideMethod();
        innerClassInsideMethod.printInnerClassInsideMethodVariables();
    }
}
