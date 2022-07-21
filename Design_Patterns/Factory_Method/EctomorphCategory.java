package lk.codelabs.traning.java.designpattern.factory.example;

public class EctomorphCategory extends Category{
    @Override
    protected void createCategory() {
        bodyAreas.add(new Chest("<= 45"));
        bodyAreas.add(new Stomach("<= 35"));
    }
}
