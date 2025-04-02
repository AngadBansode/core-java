package design;

public interface Vehicle {

    String getName(String name);

    default String getDetails(String type) {
        return type + "vehicle details";
    }
}
