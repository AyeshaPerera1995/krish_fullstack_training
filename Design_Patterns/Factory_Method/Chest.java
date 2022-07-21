package lk.codelabs.traning.java.designpattern.factory.example;

public class Chest extends BodyAreas {

    private String sizeRange;

    public Chest(String sizeRange) {
        this.sizeRange = sizeRange;
    }

    @Override
    public String toString() {
        return "Chest should be "+sizeRange;
    }
}
