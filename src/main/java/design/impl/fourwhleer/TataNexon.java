package design.impl.fourwhleer;

import design.Vehicle;
import design.impl.FourWheeler;
import design.model.Feature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TataNexon extends FourWheeler {

    private double price;

    private String desc;

    private String number;

    private List<Feature> featureList;

    @Override
    public int numberOfDoor() {
        return 5;
    }

    @Override
    public int numberOfGear() {
        return 7;
    }

    @Override
    public String getDetails(String type) {
        return type + "this is tatanexon having " + numberOfDoor() + " number of doors and " +
                numberOfGear() + " number of gears";
    }
}
