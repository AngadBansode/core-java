package design.impl;

import design.Vehicle;

public abstract class TwoWheeler implements Vehicle {

    @Override
    public String getName(String name) {
        return name;
    }

    @Override
    public String getDetails(String type) {
        return type + "two-wheeler";
    }
}
