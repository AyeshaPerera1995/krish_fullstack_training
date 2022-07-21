package lk.codelabs.traning.java.designpattern.builder;

public class Laptop {

    private final String operating_system;
    private final int ram;
    private final String processor;
    private final String brand;

    public Laptop(Builder builder) {
        this.operating_system = builder.operating_system;
        this.ram = builder.ram;
        this.processor = builder.processor;
        this.brand = builder.brand;
    }

    static class Builder{

        private String operating_system;
        private int ram;
        private String processor;
        private String brand;

        public Builder() {
        }

        public Laptop build(){
            return new Laptop(this);
        }

        public Builder operating_system(String operating_system){
            this.operating_system = operating_system;
            return this;
        }

        public Builder ram(int ram){
            this.ram = ram;
            return this;
        }

        public Builder processor(String processor){
            this.processor = processor;
            return this;
        }

        public Builder brand(String brand){
            this.brand = brand;
            return this;
        }

    }

    @Override
    public String toString() {
        return "Laptop { Operating System="+operating_system+" , Ram="+ram+" , Processor="+
                processor+" , " + "Brand="+brand+" }";
    }
}
