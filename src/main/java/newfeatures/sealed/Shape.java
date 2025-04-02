package newfeatures.sealed;

public sealed class Shape permits Circle{

    void display(){
        System.out.println("From Shape class");
    }
}
