package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class Employee implements Comparator<Employee> {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String department;
    int yearOfJoining;
    double salary;

    String email;

     public Employee(){}
    public Employee(int id,String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;

    }

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public Employee(int id, String name,int age,String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }



    @Override
    public int compare(Employee o1, Employee o2) {
        // check sal in desc order
        return (int) (o2.getSalary() - o1.getSalary());

    }
}
