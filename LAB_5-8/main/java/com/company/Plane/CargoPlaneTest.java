package com.company.Plane;

import com.company.Plane.CargoPlane;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargoPlaneTest {
    public CargoPlane pl =  new CargoPlane("a", 800, 8000, 40, 1500, "tl", 20);

    @Test
    void getLoaded() {
        pl.getLoaded();
    }

    @Test
    void setLoaded() {
        pl.setLoaded(20);
    }

    @Test
    void getModel() {
        pl.getModel();
    }

    @Test
    void setModel() {
        pl.setModel("AAb");
    }

    @Test
    void getSpeed() {
        pl.getSpeed();
    }

    @Test
    void setSpeed() {
        pl.setSpeed(200);
    }

    @Test
    void setRange() {
        pl.setRange(3000);
    }

    @Test
    void getCapacity() {
        pl.getCapacity();
    }

    @Test
    void setCapacity() {
        pl.setCapacity(10);
    }

    @Test
    void getFuelConsumption() {
        pl.getFuelConsumption();
    }

    @Test
    void setFuelConsumption() {
        pl.setFuelConsumption(1000);
    }

    @Test
    void getTypeOfLoadAutomation() {
        pl.getTypeOfLoadAutomation();
    }

    @Test
    void setTypeOfLoadAutomation() {
        pl.setTypeOfLoadAutomation("tp");
    }

    @Test
    void flightLength() {
        pl.flightLength();

    }
}