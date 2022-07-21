package lk.codelabs.traning.java.designpattern.factory.example;

import lk.codelabs.traning.java.designpattern.factory.*;
import lk.codelabs.traning.java.designpattern.factory.Package;

public class CategoryFactory {

    public static Category createCategory(CategoryCode categoryCode){
        switch (categoryCode){
            case ECTOMORPH:
                return new EctomorphCategory();
            case ENDOMORPH:
                return new EndomorphCategory();
            case MESSOMMORPH:
                return new MessomorphCategory();
            default:
                return null;
        }
    }

}
