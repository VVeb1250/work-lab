package kumying.teethawat.lab12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import kumying.teethawat.lab7.MobileDevice;

public class SmartPhone extends MobileDevice implements Serializable {
    private String name;
    private String brand;
    private double price;

    public String getName() { return this.name; }
    public String getBrand() { return this.brand; }
    public double getPrice() { return this.price; }
    public void setName(String name) { this.name = name; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setPrice(Double price) { this.price = price; }

    public SmartPhone(String name, String brand, double price, String color) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.color = color;
    }
    public SmartPhone(String name, String brand, double price) {
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
        return "SmartPhone: " + name + " (" + brand + ") " + price + " Bath";
    }

    // Custom serialization
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // Serialize SmartPhone's fields
        out.writeObject(brand);   // Serialize the 'brand' from MobileDevice (if needed)
        // You can manually serialize any other fields you need here
    }

    // Custom deserialization
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Deserialize SmartPhone's fields
        brand = (String) in.readObject(); // Deserialize the 'brand' from MobileDevice (if needed)
        // You can manually deserialize any other fields you need here
    }
}
