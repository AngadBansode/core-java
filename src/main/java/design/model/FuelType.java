package design.model;

public enum FuelType {

    PETROL("petrol"),

    DIESEL("diesel"),

    CNG("cng"),

    EV("ev");

    private String fuelType;

    FuelType(String fuelType) {
        this.fuelType = fuelType;
    }

}
