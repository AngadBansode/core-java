package exception;
// execution flow
public class TryCatchFinally {

    public static void main(String[] args) {

        System.out.println( check());
    }

    private static int check() {

        try{
            System.out.println("try:" );
            System.exit(0);
            return 1;
        }catch (Exception ex){
            System.out.println("catch");
            return 2;
        }finally{
            System.out.println("finally");
            return 3;
        }
    }
}
