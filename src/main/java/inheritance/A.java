package inheritance;

import java.math.BigDecimal;

public class A {

    int x, y = 0;

//    public A(){
//        System.out.println("default constructor- A");
//    }

    public void m1(Object obj){
        System.out.println("A: " + obj);
    }

    public A(int x, int y) {
        System.out.println("A: " + x + " " + y);
        this.x = x;
        this.y = y;
    }

    protected void methodA() {

        System.out.println("from methodA");
    }
}

class B extends A {


    public B(int x, int y) {
        super(30, 40);
    }

        public B() {
        super(10, 20);
    }
    @Override
    public void methodA() {
        System.out.println("from methodB");
    }
    @Override
    public void m1(Object str){
        System.out.println("A: " + str);
    }

    public static void main(String[] args) {

        A a = new B(80,90);
//        a.methodB();
        a.methodA();

        System.out.println(a.x);
    }
}