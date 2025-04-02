package design;

import design.impl.fourwhleer.TataNexon;
import design.model.EngineDetail;
import design.model.Feature;
import design.model.FuelType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) {

        TataNexon tataNexon = new TataNexon();

        List<EngineDetail> engineDetails = new ArrayList<>();
        engineDetails.add(new EngineDetail("facelift", 1200, 12.5, FuelType.PETROL));
        engineDetails.add(new EngineDetail("pure", 1600, 15.5, FuelType.DIESEL));
        engineDetails.add(new EngineDetail("smart", 800, 9.5, FuelType.CNG));

        List<Feature> list = new ArrayList<>();

        list.add(new Feature("facelift", 06, 10, engineDetails));
        list.add(new Feature("pure", 06, 8, engineDetails));
        list.add(new Feature("smart", 06, 06, engineDetails));

        tataNexon.setDesc("tata nexon facelift model");
        tataNexon.setNumber("24BH2578A");
        tataNexon.setPrice(1500000.25);
        tataNexon.setFeatureList(list);

        createModel(tataNexon);

    }

    private static void createModel(TataNexon tataNexon) {

        var collect = tataNexon.getFeatureList().stream().map(Main::mapEngineDetails).toList();

        collect.forEach(System.out::println);
    }

    private static Object mapEngineDetails(Feature feature) {
        return feature.getEngineDetails().stream().filter(engineType -> engineType.getCapacity() > 1000)
                .map(tork -> {
                    var v = tork.getTork() + 3;
                    tork.setTork(v);
                    return tork;
                }).collect(Collectors.toList());

    }
}
