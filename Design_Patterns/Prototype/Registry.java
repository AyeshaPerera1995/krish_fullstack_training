package lk.codelabs.traning.java.designpattern.protype.example;

import java.util.HashMap;
import java.util.Map;

public class Registry {

    private Map<CakeType, Cake> cakes = new HashMap<>();

    public Registry() {
        initialize();
    }

    public Cake getCake(CakeType cakeType){
        Cake cake;
        try {
            cake = (Cake) cakes.get(cakeType).clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return cake;
    }

    private void initialize() {
        ButterCake butterCake = new ButterCake();
        butterCake.setDesign("tree");
        butterCake.setColor("green");
        butterCake.setFlavour("vanilla");
        butterCake.setIcingType("fondant_icing");

        ChocolateCake chocolateCake = new ChocolateCake();
        chocolateCake.setDesign("animal");
        chocolateCake.setColor("brown");
        chocolateCake.setFlavour("chocolate");

        cakes.put(CakeType.BUTTER_CAKE, butterCake);
        cakes.put(CakeType.CHOCOLATE_CAKE,chocolateCake);

    }

}
