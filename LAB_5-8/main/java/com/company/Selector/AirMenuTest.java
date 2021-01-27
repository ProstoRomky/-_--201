package com.company.Selector;
import com.company.AirLine.AirLine;
import com.company.Plane.CargoPlane;
import com.company.Plane.PassangerPlane;
import com.company.Plane.Plane;
import com.company.Selector.AirMenu;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;

class AirMenuTest {
    AirMenu data = new AirMenu();
    LinkedList<AirLine> airlines =new LinkedList<>();;
    LinkedList<Plane> planes = new LinkedList<>();;
    LinkedList<PassangerPlane> passPlane = new LinkedList<>();
    LinkedList<CargoPlane> cargoPlane= new LinkedList<>();



@BeforeEach
   public void testInit_AirLine() {
    data.init_Planes();
    data.init_AirLine();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Airline.txt"))) {

            airlines = ((LinkedList<AirLine>) ois.readObject());

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }
@BeforeEach
    public void testInit_Planes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("CargoPlane.txt"))) {

            cargoPlane = ((LinkedList<CargoPlane>) ois.readObject());
            for (CargoPlane item:cargoPlane){
                planes.add(item);

            }


        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("PassPlane.txt"))) {

            passPlane = ((LinkedList<PassangerPlane>) ois.readObject());
            for (PassangerPlane item:passPlane){
                planes.add(item);

            }

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }


    }






    @Test
    void testDiap() {
        AirLine choosen = airlines.get(0);
        LinkedList<Plane> overallList= choosen.getPlanes();
        System.out.println(overallList);
        LinkedList<Plane> expectedList= new LinkedList<>();
        expectedList.add(overallList.get(1));
        expectedList.add(overallList.get(2));
        LinkedList<Plane> actual= data.diapTest(1);
        LinkedList<String> expected= new LinkedList<>();
        LinkedList<String> act= new LinkedList<>();
        for (Plane p : expectedList) {
            expected.add(p.getModel()+p.getCapacity()+p.getFuelConsumption());
        }
        for (Plane p :actual) {
            act.add(p.getModel()+p.getCapacity()+p.getFuelConsumption());
        }
        Assert.assertEquals(expected,act);

    }

    @Test
    void testShow() {
        LinkedList<String> expected = new LinkedList<>();
        LinkedList<String> real = data.show();
        for (AirLine airline : airlines) {
            expected.add(airline.getName()+" Чартерні перельоти:"+airline.isCharter()+" тип: "+ airline.getType());
        }
        Assert.assertEquals(expected,real);

    }

    @Test
    void testShowPlane() {
        AirLine choosen = airlines.get(0);
        LinkedList<String> expectedList= new LinkedList<>();
        for (Plane plane : choosen.getPlanes()) {
            expectedList.add(plane.getModel());
        }

        Assert.assertEquals(expectedList,data.showPlane(1));


    }

    @Test
    void testCountPlane() {
        AirLine choosen = airlines.get(0);
        LinkedList<String> expectedList= new LinkedList<>();
        int capacity = 0;

        for (Plane plane : choosen.getPlanes()) {
            capacity+= plane.getNumOfSeats();
        }

        expectedList.add("Загальна місткість - " + capacity);
        double takeoff = 0;
        for (Plane plane : choosen.getPlanes()) {
            takeoff+= plane.getCapacity();
        }

        expectedList.add("Загальна вантажопідйомність - " + takeoff);
        Assert.assertEquals(expectedList,data.countPlane(1));

    }

    @Test
    void testChooseAirline() {

    }

    @Test
    void testMakeCompany() {
      LinkedList<CargoPlane> list2 = new LinkedList<>();
      CargoPlane pl =  new CargoPlane("a", 800, 8000, 40, 1500, "tl", 20);
      list2.add(pl);
      LinkedList<PassangerPlane> list = new LinkedList<>();
      PassangerPlane pl2 =  new PassangerPlane("a",2000,300,5000,40,3000);
      list.add(pl2);
      LinkedList<Plane> plane = new LinkedList<>();
    AirLine expected = new AirLine(true,"AAA","cont",1,1,list,list2,plane );
    AirLine actual = data.makeCompanyTest();
        Assert.assertEquals(expected.getName()+expected.getType()+expected.getNumOfCargoPalnes()+expected.getNumOfPassangerPlane()
                ,actual.getName()+actual.getType()+actual.getNumOfCargoPalnes()+actual.getNumOfPassangerPlane());

    }

    @Test
    void testDeleteSmth() {
        AirLine choosen = airlines.get(0);
        LinkedList<Plane> expected1 = choosen.getPlanes();
        expected1.remove(0);
        LinkedList<Plane> actual = data.deleteSmthTest(1);
        LinkedList<String> expected= new LinkedList<>();
        LinkedList<String> act= new LinkedList<>();
        for (Plane p : expected1) {
            expected.add(p.getModel()+p.getCapacity()+p.getFuelConsumption());
        }
        for (Plane p :actual) {
            act.add(p.getModel()+p.getCapacity()+p.getFuelConsumption());
        }

        Assert.assertEquals(expected,act);

    }


    @Test
    void testChange() {
        AirLine choosen = airlines.get(0);
        int switched = 1;
        LinkedList<Plane> planes = choosen.getPlanes();
        PassangerPlane expectedP = new PassangerPlane("a",2000,300,5000,40,3000);
        planes.set(switched - 1,expectedP);
        LinkedList<Plane> actual = data.changeTest(1);
        LinkedList<String> expected= new LinkedList<>();
        LinkedList<String> act= new LinkedList<>();
        for (Plane p : planes) {
            expected.add(p.getModel()+p.getCapacity()+p.getFuelConsumption());
        }
        for (Plane p :actual) {
            act.add(p.getModel()+p.getCapacity()+p.getFuelConsumption());
        }
        Assert.assertEquals(expected,act);

    }

    @Test
    void testAddPlane() {
        AirLine choosen = airlines.get(0);
        LinkedList<Plane> expectedList= choosen.getPlanes();
        PassangerPlane plane = data.makePassPlaneTest();
        expectedList.add(plane);
        LinkedList<Plane> actual= data.addPlaneTest(1);
        LinkedList<String> expected= new LinkedList<>();
        LinkedList<String> act= new LinkedList<>();
        for (Plane p : expectedList) {
            expected.add(p.getModel()+p.getCapacity()+p.getTypeOfLoadAutomation()+p.getFuelConsumption());
        }
        for (Plane p :actual) {
            act.add(p.getModel()+p.getCapacity()+p.getTypeOfLoadAutomation()+p.getFuelConsumption());
        }
        Assert.assertEquals(expected,act);



    }

    @Test
    void testMakeCargoPlane() {
        CargoPlane expectedPlane = new CargoPlane("a", 800, 8000, 40, 1500, "tl", 20);
        CargoPlane actualPlane = data.makeCargoPlaneTest();
        String expected = expectedPlane.getModel()+expectedPlane.getSpeed()+expectedPlane.getRange()+expectedPlane.getCapacity()+expectedPlane.getFuelConsumption();
        String actual = actualPlane.getModel()+actualPlane.getSpeed()+actualPlane.getRange()+actualPlane.getCapacity()+actualPlane.getFuelConsumption();


        Assert.assertEquals(expected,actual);


    }

    @Test
    void testMakePassPlane() {
        PassangerPlane expectedP = new PassangerPlane("a",2000,300,5000,40,3000);
        PassangerPlane actualP = data.makePassPlaneTest();
        String expected = expectedP.getModel()+expectedP.getSpeed()+expectedP.getNumOfSeats()+expectedP.getRange()+expectedP.getCapacity()+expectedP.getFuelConsumption();
        String actual = actualP.getModel()+actualP.getSpeed()+actualP.getNumOfSeats()+actualP.getRange()+actualP.getCapacity()+actualP.getFuelConsumption();

        Assert.assertEquals(expected,actual);
    }

}

