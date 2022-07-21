package lk.codelabs.traning.java.designpattern.protype.example;

public class Cake implements Cloneable{

    private String color;
    private String design;  // animal, tree, flower
    private String flavour; // vanilla,orange, strawberry


    public void setColor(String color) {
        this.color = color;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
