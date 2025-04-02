package Object;

import java.util.Objects;

public class EqualsOverride {



    public static void main(String[] args) {

        Person person1 = new Person();

        person1.name = "Alice";

        person1.age = 30;



        Person person2 = new Person();

        person2.name = "Alice";

        person2.age = 30;



        System.out.println(person1.equals(person2)); // This will print "false" because they are different objects

    }

}
class Person {

    String name;

    int age;



    // Default equals method (checks reference equality)
//   System.out.println(person1.equals(person2));
//   This will print "false" because they are different objects
//    public boolean equals(Object obj) {
//
//        return super.equals(obj);
//
//    }

     // override equals from Object class
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);

    }


}
