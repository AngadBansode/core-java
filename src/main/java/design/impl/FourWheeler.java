package design.impl;

import design.Vehicle;

public abstract class  FourWheeler implements Vehicle {

    @Override
    public String getName(String name) {
        return name;
    }

    @Override
    public String getDetails(String type) {
        return type + "four-wheeler";
    }

    public abstract int numberOfDoor();
    public abstract int numberOfGear();
}
