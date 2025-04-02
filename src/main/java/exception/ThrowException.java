package exception;


public class ThrowException {
    public static void main(String[] args)   {

        String val = "";
        try {
            parseMethod(val);
        } catch (Exception ex){
            System.out.println("Exception:" + ex);
        }
        System.out.println("From main");
    }

    public static void parseMethod(String val) throws Exception {
        try {
            Integer parsedInt = Integer.parseInt(val);
        } catch (Exception ex) {
            System.out.println("exception caught in parseMethod");
        }
        System.out.println("after catch..." );
    }
}
