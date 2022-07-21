package lk.codelabs.traning.java.designpattern.factory.example;

public class MessomorphCategory extends Category{
    @Override
    protected void createCategory() {
        bodyAreas.add(new Chest("< 60 and > 45"));
        bodyAreas.add(new Stomach("< 50 and > 35"));
    }
}
