package lk.codelabs.traning.java.designpattern.factory.example;

public class Main {
    public static void main(String[] args) {

        Category ectCategory = CategoryFactory.createCategory(CategoryCode.ECTOMORPH);
        System.out.println(ectCategory);

        Category endCategory = CategoryFactory.createCategory(CategoryCode.ENDOMORPH);
        System.out.println(endCategory);

        Category messCategory = CategoryFactory.createCategory(CategoryCode.MESSOMMORPH);
        System.out.println(messCategory);

    }
}
