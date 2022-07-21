package lk.codelabs.traning.java.designpattern.protype.example;

public class ButterCake extends Cake{

    private String icingType; //fondant icing or butter icing

    public void setIcingType(String icingType) {
        this.icingType = icingType;
    }

    @Override
    public String toString() {
        return "Butter Cake: { Icing Type="+icingType+" }";
    }
}
