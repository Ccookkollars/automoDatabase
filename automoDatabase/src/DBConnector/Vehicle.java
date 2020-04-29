/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnector;

/**
 *
 * @author in communist project no authors
 */
public class Vehicle {
    private String vin;
    private String make;
    private String model;
    private String plate;
    private String color;

    public Vehicle(String vin, String make, String model, String plate, String color) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.plate = plate;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicle{vin=").append(vin);
        sb.append(", make=").append(make);
        sb.append(", model=").append(model);
        sb.append(", plate=").append(plate);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
    
}
