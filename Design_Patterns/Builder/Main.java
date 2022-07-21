package lk.codelabs.traning.java.designpattern.builder;

public class Main {
    public static void main(String[] args) {

        Laptop.Builder builder1 = new Laptop.Builder();
        Laptop laptop1 = builder1.ram(4).brand("Dell").processor("i3").operating_system("Win7").build();
        System.out.println(laptop1);

        Laptop.Builder builder2 = new Laptop.Builder();
        Laptop laptop2 = builder2.ram(12).brand("HP").processor("i7").build();
        System.out.println(laptop2);

        Laptop.Builder builder3 = new Laptop.Builder();
        Laptop laptop3 = builder3.brand("Asus").build();
        System.out.println(laptop3);

    }
}
