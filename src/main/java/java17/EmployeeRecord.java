package java17;
// we cant extends or inherits the record
public record EmployeeRecord(String name, int number) {

    private static final String DEFAULT_NAME = "ANGAD";
    private static final int DEFAULT_NUMBER = 12345;

    // we cant create instance variables here
    //private static String id = 123;

    // canonical ctor
    public EmployeeRecord {
        if (number < 0) {
            throw new IllegalArgumentException("NUmber cant be negative");
        }
    }

    public EmployeeRecord (String name){
        this(name, DEFAULT_NUMBER);
    }

    public String nameInUpperCase() {
        return name.toUpperCase();
    }

    public static void printWhatever() {
        System.out.println("whatever");
    }
}
