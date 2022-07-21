package lk.codelabs.traning.java.designpattern.factory.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Category {

    protected List<BodyAreas> bodyAreas = new ArrayList<>();

    public Category() {
        createCategory();
    }

    protected abstract void createCategory();

    @Override
    public String toString() {
        return "Category {Body Areas " + bodyAreas + " }";
    }
}
