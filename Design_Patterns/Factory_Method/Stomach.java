package lk.codelabs.traning.java.designpattern.factory.example;

public class Stomach extends BodyAreas{
    private String sizeRange;

    public Stomach(String sizeRange) {
        this.sizeRange = sizeRange;
    }

    @Override
    public String toString() {
        return "Stomach should be "+sizeRange;
    }
}
