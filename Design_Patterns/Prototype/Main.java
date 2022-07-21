package lk.codelabs.traning.java.designpattern.protype.example;

public class Main {
    public static void main(String[] args) {

        Registry registry = new Registry();

        ButterCake butterCake = (ButterCake) registry.getCake(CakeType.BUTTER_CAKE);
        System.out.println(butterCake);

        Cake butterCake2 = (Cake) registry.getCake(CakeType.CHOCOLATE_CAKE);
        System.out.println(butterCake2);

    }
}
