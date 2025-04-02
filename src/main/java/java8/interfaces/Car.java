package java8.interfaces;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car implements Vehicle, Alarm {

    private String brand;

    // constructors/getters

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "The car is speeding up.";
    }

    @Override
    public String slowDown() {
        return "The car is slowing down.";
    }

    //    @Override
//    public String turnAlarmOn() {
//        return Alarm.super.turnAlarmOn();
//    }
//
//    @Override
//    public String turnAlarmOff() {
//        return Vehicle.super.turnAlarmOff();
//    }
    @Override
    public String turnAlarmOn() {
        return Vehicle.super.turnAlarmOn() + " " + Alarm.super.turnAlarmOn();
    }

    @Override
    public String turnAlarmOff() {
        return Vehicle.super.turnAlarmOff() + " " + Alarm.super.turnAlarmOff();
    }

    static void printCarDetails(){
        System.out.println("Car details");
    }


    public static void main(String[] args) {
        Vehicle car = new Car("BMW");
        System.out.println(car.getBrand());
        System.out.println(car.speedUp());
        System.out.println(car.slowDown());
        System.out.println(car.turnAlarmOn());
        System.out.println(car.turnAlarmOff());
        System.out.println(Vehicle.getHorsePower(2500, 480));

        Car car1 = new Car("TATA");
        System.out.println(car1.getBrand());
        car1.printCarDetails();
    }
}
