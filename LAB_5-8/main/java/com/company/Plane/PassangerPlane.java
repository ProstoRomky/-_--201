package com.company.Plane;

import java.util.Comparator;
import java.io.Serializable;
public class PassangerPlane extends Plane implements Serializable{
    private String model;
    private double speed;
    private double range;
    private double capacity;
    private double fuelConsumption;
    private int numOfSeats;

    public PassangerPlane(String model, double speed,int numOfSeats, double range, double capacity, double fuelConsumption) {
        super(model,speed,numOfSeats, range, capacity, fuelConsumption);
        this.model = model;
        this.speed = speed;
        this.range = range;
        this.capacity = capacity;
        this.fuelConsumption = fuelConsumption;
        this.numOfSeats = numOfSeats;
    }
    public static Comparator<PassangerPlane> byRange = Comparator.comparing(s -> s.flightLength());

    @Override
    public String toString() {
        return "PassangerPlane{" +
                "model='" + model + '\'' +
                ", speed=" + speed +
                ", range=" + range +
                ", capacity=" + capacity +
                ", fuelConsumption=" + fuelConsumption +
                ", numOfSeats=" + numOfSeats +
                '}';
    }

    @Override
    public double flightLength() {
        return range-0.02;
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

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public void setRange(int range) {
        this.range = range;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }
}
