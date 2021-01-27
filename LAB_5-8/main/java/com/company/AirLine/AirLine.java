package com.company.AirLine;

import com.company.Plane.CargoPlane;
import com.company.Plane.PassangerPlane;
import com.company.Plane.Plane;

import java.io.Serializable;
import java.util.*;

public class AirLine implements Serializable {
    private boolean charter;
    private String name;
    private String type;
    private int numOfPassangerPlane;
    private int numOfCargoPalnes;
    private LinkedList<CargoPlane> cargoPlanes = new LinkedList<>();
    private LinkedList<PassangerPlane> passPlanes = new LinkedList<>();
    private LinkedList<Plane> Planes = new LinkedList<>();


    public AirLine(boolean charter, String name, String type, int numOfPassangerPlane, int numOfCargoPalnes, LinkedList<PassangerPlane> passPlanes, LinkedList<CargoPlane> cargoPlanes,LinkedList<Plane> Planes) {
        this.charter = charter;
        this.name = name;
        this.type = type;
        this.numOfPassangerPlane = numOfPassangerPlane;
        this.numOfCargoPalnes = numOfCargoPalnes;
        this.Planes = Planes;

    }


    public LinkedList<CargoPlane> getCargoPlanes() {
        return cargoPlanes;
    }

    public void setCargoPlanes(LinkedList<CargoPlane> cargoPlanes) {
        this.cargoPlanes = cargoPlanes;
    }

    public LinkedList<PassangerPlane> getPassPlanes() {
        return passPlanes;
    }

    public void setPassPlanes(LinkedList<PassangerPlane> passPlanes) {
        this.passPlanes = passPlanes;
    }

    public LinkedList<Plane> getPlanes() {
        return Planes;
    }

    public void setPlanes(LinkedList<Plane> planes) {
        Planes = planes;
    }

    public boolean isCharter() {
        return charter;
    }

    public void setCharter(boolean charter) {
        this.charter = charter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumOfPassangerPlane() {
        return numOfPassangerPlane;
    }

    public void setNumOfPassangerPlane(int numOfPassangerPlane) {
        this.numOfPassangerPlane = numOfPassangerPlane;
    }

    public int getNumOfCargoPalnes() {
        return numOfCargoPalnes;
    }

    public void setNumOfCargoPalnes(int numOfCargoPalnes) {
        this.numOfCargoPalnes = numOfCargoPalnes;
    }


}
