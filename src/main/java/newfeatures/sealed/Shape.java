package newfeatures.sealed;

public sealed class Shape permits Circle, Rectangle {

    void display(){
        System.out.println("From Shape class");
    }
}
