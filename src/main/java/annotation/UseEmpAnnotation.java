package annotation;

import java.util.Arrays;

@Employee(name = "John", id = 101, mobileNumber = {12345, 9876})
@Employee(name = "Smith", id = 102, mobileNumber = {12346, 9877})
@Employee(name = "Peter", id = 103, mobileNumber = {12347, 9878})
public class UseEmpAnnotation {

//        @Employee(name = "John", id = 101, mobileNumber = {12345,9876})
    public static void main(String[] args) {
        getEmpDetails();
    }

//    @Employee(name = "John", id = 101, mobileNumber = {12345, 9876})
    private static void getEmpDetails() {
//        Employee emp = UseEmpAnnotation.class.getAnnotation(Employee.class);
        Employee[] emp = UseEmpAnnotation.class.getAnnotationsByType(Employee.class);
        for (Employee e : emp) {
            printEmpDetails(e);
        }

    }

    private static void printEmpDetails(Employee e) {
        System.out.println("Name: " + e.name());
        System.out.println("Id: " + e.id());
        System.out.println("Mobile Number: " + Arrays.toString(e.mobileNumber()));
    }
}
