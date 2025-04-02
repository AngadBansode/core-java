package org.example;

public class ReturnCheck {

    public static void main(String[] args) {

        System.out.println("Welcome");

        if(10 < 5){
            System.out.println("true");
           return;
        }
        else
            System.out.println("false");

        System.out.println("Done");

        print();
    }

    private static void print() {
        System.out.println("print");
    }
}
