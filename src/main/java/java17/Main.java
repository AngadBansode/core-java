package java17;

public class Main {

    public static void main(String[] args) {

        EmployeeRecord employeeRecord = new EmployeeRecord("Ravi", 123);

        System.out.println(employeeRecord.name());
        EmployeeRecord.printWhatever();
        System.out.println( employeeRecord.nameInUpperCase());
    }
}
