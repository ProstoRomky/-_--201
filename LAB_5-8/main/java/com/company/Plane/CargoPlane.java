package com.company.Plane;

import java.io.Serializable;
import java.util.Comparator;

public class CargoPlane extends Plane implements Serializable {
    private String model;
    private double speed;
    private double range;
    private double capacity;
    private double fuelConsumption;
    private String typeOfLoadAutomation;
    private double loaded;

    public CargoPlane(String model, double speed, double range, double capacity, double fuelConsumption, String typeOfLoadAutomation,double loaded) {
        super(model, speed, range, capacity, fuelConsumption, typeOfLoadAutomation,loaded);
        this.model = model;
        this.speed = speed;
        this.range = range;
        this.capacity = capacity;
        this.fuelConsumption = fuelConsumption;
        this.typeOfLoadAutomation = typeOfLoadAutomation;
        this.loaded = loaded;
    }
    public static Comparator<CargoPlane> byRange = Comparator.comparing(s -> s.flightLength());


    public double getLoaded() {
        return loaded;
    }

    public void setLoaded(double loaded) {
        this.loaded = loaded;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String getTypeOfLoadAutomation() {
        return typeOfLoadAutomation;
    }

    public void setTypeOfLoadAutomation(String typeOfLoadAutomation) {
        this.typeOfLoadAutomation = typeOfLoadAutomation;
    }

    @Override
    public double flightLength() {

        return range - (loaded*0.075);
    }



}
