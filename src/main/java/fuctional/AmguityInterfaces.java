package fuctional;

public class AmguityInterfaces implements I1, I2 {

    public static void main(String[] args) {
        System.out.println(new AmguityInterfaces().m1());
        ;
    }


    @Override
    public String m1() {
        return " I2.super.m1();";
    }



}
