package lk.codelabs.traning.java.designpattern.factory.example;

public class EndomorphCategory extends Category{
    @Override
    protected void createCategory() {
        bodyAreas.add(new Chest(">= 60"));
        bodyAreas.add(new Stomach(">= 50"));
    }
}
