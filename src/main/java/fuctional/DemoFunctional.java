package fuctional;

@FunctionalInterface
public interface DemoFunctional {

   String printUpperCase(String name);

   default int doCalcualtion(int n1, int n2){
       System.out.println("Default adding...");
       return n1+n2;
   }

}
class DemoImpl implements DemoFunctional{

    @Override
    public String printUpperCase(String name) {
        return name.toUpperCase();
    }

    @Override
    public int doCalcualtion(int n1, int n2) {
        System.out.println("From child...");
        return n1*n2;
    }
}


class DemoFunctionalMain{
    public static void main(String[] args) {

//        Runtime Poly -- overriding
        DemoFunctional ref = new DemoImpl();

      int output =    ref.doCalcualtion(10, 20);
        System.out.println(output);


    }
}
