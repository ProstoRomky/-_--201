package com.company.Plane;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {
    public PassangerPlane pl2 =  new PassangerPlane("a",2000,300,5000,40,3000);

    @Test
    void testToString() {
        pl2.toString();
    }

    @Test
    void flightLength() {
        pl2.flightLength();
    }

    @Test
    void getModel() {
        pl2.getModel();
    }

    @Test
    void setModel() {
        pl2.setModel("sds");
    }

    @Test
    void getSpeed() {
        pl2.getSpeed();
    }

    @Test
    void setSpeed() {
        pl2.setSpeed(2000);
    }

    @Test
    void setRange() {
        pl2.setRange(3233);
    }

    @Test
    void getCapacity() {
        pl2.getCapacity();
    }

    @Test
    void setCapacity() {
        pl2.setCapacity(23);
    }

    @Test
    void getFuelConsumption() {
        pl2.getFuelConsumption();
    }

    @Test
    void setFuelConsumption() {
        pl2.setFuelConsumption(2000);
    }

    @Test
    void getNumOfSeats() {
        pl2.getNumOfSeats();

    }

    @Test
    void setNumOfSeats() {
        pl2.setNumOfSeats(200);
    }



    @Test
    void getTypeOfLoadAutomation() {
    }

    @Test
    void setTypeOfLoadAutomation() {
    }

    @Test
    void getLoaded() {
    }

    @Test
    void setLoaded() {
    }
}