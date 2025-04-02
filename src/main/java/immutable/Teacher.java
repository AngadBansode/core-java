package immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record Teacher(String name, List<Address> addresses) {


    public Teacher(String name, List<Address> addresses) {

        this.name = name;
        this.addresses = addresses == null ? Collections.emptyList()
                : List.copyOf(addresses);

    }
}

class TeacherMain {

    public static void main(String[] args) {
        Address ad_1 = new Address("Pune", 1234);
        Address ad_2 = new Address("Hyd", 4567);
        Teacher teacher = new Teacher("Rahul", List.of(ad_1, ad_2));

        System.out.println(teacher.name());
        System.out.println(teacher.addresses().size());
        System.out.println(teacher.addresses().get(0));

        // modify add

        teacher.addresses().add(new Address("Bangalore", 98081));//UnsupportedOperationException
        System.out.println(teacher.addresses().get(0));


    }


}
