package kumying.teethawat.lab12;

import java.io.Serializable;

import kumying.teethawat.lab7.MobileDevice;

public class Tablet extends MobileDevice implements Serializable {
    private String name;
    private String brand;
    private double price;

    public String getName() { return this.name; }
    public String getBrand() { return this.brand; }
    public double getPrice() { return this.price; }
    public void setName(String name) { this.name = name; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setPrice(Double price) { this.price = price; }

    public Tablet(String name, String brand, double price, String color) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.color = color;
    }
    public Tablet(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    @Override
    public boolean isWatch() {
        return false;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Tablet: " + name + " (" + brand + ") " + price + " Bath";
    }

}
