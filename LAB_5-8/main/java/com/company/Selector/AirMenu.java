package com.company.Selector;
import com.company.Main;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import com.company.AirLine.AirLine;
import com.company.Plane.CargoPlane;
import com.company.Plane.PassangerPlane;
import com.company.Plane.Plane;
import org.apache.log4j.xml.DOMConfigurator;
import java.lang.ClassNotFoundException;
import java.io.*;
import java.util.*;

public class AirMenu {
    private Scanner in= new Scanner(System.in);
    public LinkedList<AirLine> airlines = new LinkedList<>();
    public LinkedList<Plane> planes = new LinkedList<>();
    public LinkedList<CargoPlane> cargoPlane = new LinkedList<>();
    public LinkedList<PassangerPlane> passPlane = new LinkedList<>();

    static Logger logger = Logger.getLogger(AirMenu.class);

    static {
        DOMConfigurator.configure("log4j.xml");
    }


    public void init_AirLine() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Airline.txt"))) {

            airlines = ((LinkedList<AirLine>) ois.readObject());
            logger.info("File was opened");
        } catch (FileNotFoundException e) {
            logger.error("File not found.");
        } catch (IOException e) {
            logger.error("Error initializing stream.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.error("Class not found.");
        }

    }


    public void init_Planes() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("CargoPlane.txt"))) {

            cargoPlane = ((LinkedList<CargoPlane>) ois.readObject());
            for (CargoPlane item:cargoPlane){
                planes.add(item);
                System.out.println(item);
            }


        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("PassPlane.txt"))) {

            passPlane = ((LinkedList<PassangerPlane>) ois.readObject());
            for (PassangerPlane item:passPlane){
                planes.add(item);
                System.out.println(item);
            }

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }


    }

    public LinkedList<Plane> diapTest(int option){
        AirLine choosen = airlines.get(option - 1);
        double start = 1000;
        double end = 4000;
        LinkedList<Plane> planeList = choosen.getPlanes();
        LinkedList<Plane> testList = new LinkedList<>();
        for (Plane plane : planeList) {
            if (plane.getFuelConsumption() >= start && plane.getFuelConsumption() <= end) {
                System.out.println(plane.getModel() + "\tСпоживання пального : " +plane.getFuelConsumption());
                testList.add(plane);
            }
        }
        return testList;
    }
 public LinkedList<Plane> diap(int option) {
     AirLine choosen = airlines.get(option - 1);
     System.out.println("Введіть діапазон споживання пального: ");
     System.out.println("Введіть початок");
     double start = in.nextDouble();
     System.out.println("Введіть кінець");
     double end = in.nextDouble();
     LinkedList<Plane> planeList = choosen.getPlanes();
     LinkedList<Plane> testList = new LinkedList<>();
     for (Plane plane : planeList){
         System.out.println(plane);
     }
     for (Plane plane : planeList) {
         if (plane.getFuelConsumption() >= start && plane.getFuelConsumption() <= end) {
             System.out.println(plane.getModel() + "\tСпоживання пального : " +plane.getFuelConsumption());
             testList.add(plane);
         }
     }
     return testList;
     }
    public LinkedList<String> show() {
        LinkedList<String> a = new LinkedList<>();
        for (AirLine airline : airlines) {
            System.out.println(airline.getName()+" Чартерні перельоти:"+airline.isCharter()+"\tтип: "+ airline.getType());
            a.add(airline.getName()+" Чартерні перельоти:"+airline.isCharter()+"\tтип: "+ airline.getType());
        }
        return a;
    }

        public LinkedList<String> showPlane(int option) {
        AirLine choosen = airlines.get(option - 1);
        LinkedList<String> a = new LinkedList<>();
        for (Plane plane : choosen.getPlanes()) {
            System.out.println(plane.getModel());
            a.add(plane.getModel());
        }
//        for (Plane plane : choosen.getPlanes()) {
//            System.out.println(plane);
//        }
       return a;
    }

    public LinkedList<String> countPlane(int option) {
        LinkedList<String> a = new LinkedList<>();
        AirLine choosen = airlines.get(option - 1);
        int capacity = 0;
        for (Plane plane : choosen.getPlanes()) {
            System.out.println(plane.getModel()+"\tМісткість "+plane.getNumOfSeats()+"\tЗавантаженість: "+plane.getCapacity());
        }
        for (Plane plane : choosen.getPlanes()) {
            capacity+= plane.getNumOfSeats();
        }
        System.out.println("Загальна місткість - " + capacity);
        a.add("Загальна місткість - " + capacity);
        double takeoff = 0;
        for (Plane plane : choosen.getPlanes()) {
            takeoff+= plane.getCapacity();
        }
        System.out.println("Загальна вантажопідйомність - " + takeoff);
        a.add("Загальна вантажопідйомність - " + takeoff);
        return a;
    }

    public void sortPlane(int option) {
        AirLine choosen = airlines.get(option - 1);
        LinkedList<Plane> sortList = choosen.getPlanes();
        sortList.sort(Plane.byRange);

        System.out.println("Сортований список");
        for (Plane plane : sortList) {
            System.out.println(plane.getModel() + " Дальність польоту: " + plane.flightLength()+" km");
        }
    }
    public  AirLine makeCompanyTest(){
            String name = "AAA";
            String type = "cont";
            int passNum = 1;
        LinkedList<CargoPlane> makedCargoPlane = new LinkedList<>();
        LinkedList<PassangerPlane> makedPassPlane = new LinkedList<>();
        LinkedList<Plane> makedPlane = new LinkedList<>();
        for (int i = 0; i < passNum; i++) {
            PassangerPlane makedPlanePass = makePassPlaneTest();
            makedPassPlane.add(makedPlanePass);
            makedPlane.add(makedPlanePass);
        }
        int cargoNum = 1;

        for (int i = 0; i < cargoNum; i++) {
            CargoPlane makedPlaneCargo = makeCargoPlaneTest();
            makedCargoPlane.add(makedPlaneCargo);
            makedPlane.add(makedPlaneCargo);
        }

        AirLine newAir = new AirLine(true, name, type, passNum, cargoNum, makedPassPlane, makedCargoPlane,makedPlane);
        airlines.add(newAir);
        return newAir;
    }

    public void makeCompany() {
        System.out.println("Введіть назву компанії: ");
        String name = in.nextLine();
        System.out.println("Введіть тип компанії:");
        String type = in.nextLine();
        System.out.println("Введіть к-сть пасажирських літаків: ");
        int passNum = in.nextInt();
        System.out.println("Чи наявні чартерні перельоти?: ");
        boolean charter = in.nextBoolean();
        in.nextLine();
        LinkedList<CargoPlane> makedCargoPlane = new LinkedList<>();
        LinkedList<PassangerPlane> makedPassPlane = new LinkedList<>();
        LinkedList<Plane> makedPlane = new LinkedList<>();
        for (int i = 0; i < passNum; i++) {
            PassangerPlane makedPlanePass = makePassPlane();
            makedPassPlane.add(makedPlanePass);
            makedPlane.add(makedPlanePass);
        }
        System.out.println("Введіть к-сть вантажних літаків: ");
        int cargoNum = in.nextInt();
        in.nextLine();

        for (int i = 0; i < cargoNum; i++) {
            CargoPlane makedPlaneCargo = makeCargoPlane();
            makedCargoPlane.add(makedPlaneCargo);
            makedPlane.add(makedPlaneCargo);
        }

        AirLine newAir = new AirLine(charter, name, type, passNum, cargoNum, makedPassPlane, makedCargoPlane,makedPlane);
        airlines.add(newAir);
        System.out.println("Ви додали авіакомпанію");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Airline.txt")))
        {
            oos.writeObject(airlines);

        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

    }
    public  LinkedList<Plane> deleteSmthTest(int option){
        int delPlane = 1;
        AirLine choosen = airlines.get(option - 1);
        LinkedList<Plane> allPlane = choosen.getPlanes();
        allPlane.remove(delPlane-1);
        return allPlane;
    }

    public void deleteSmth(int option) {
        showPlane(option);
        System.out.println("Виберіть літак для видалення");
        int delPlane = in.nextInt();
        AirLine choosen = airlines.get(option - 1);
        LinkedList<Plane> allPlane = choosen.getPlanes();
        allPlane.remove(delPlane-1);
        if (delPlane > choosen.getNumOfCargoPalnes()) {
            LinkedList<PassangerPlane> delFromList = choosen.getPassPlanes();
            delFromList.remove(delPlane - 1 - choosen.getNumOfCargoPalnes());
            choosen.setPassPlanes(delFromList);
            choosen.setNumOfPassangerPlane(choosen.getNumOfPassangerPlane() - 1);

        } else {
            LinkedList<CargoPlane> delFromList = choosen.getCargoPlanes();
            delFromList.remove(delPlane - 1);
            choosen.setCargoPlanes(delFromList);
            choosen.setNumOfCargoPalnes(choosen.getNumOfCargoPalnes() - 1);
        }
        airlines.set(option-1,choosen);
        writeAir();
        System.out.println("Літак видалено.");


    }

   public void exit() {
        System.out.println("Exiting");

    }
    public LinkedList<Plane> changeTest(int option){
        AirLine choosen = airlines.get(option - 1);
        int switched = 1;
        LinkedList<Plane> allPlanes = choosen.getPlanes();
        PassangerPlane plane = makePassPlaneTest();
        allPlanes.set(switched - 1,plane);
        return allPlanes;

    }
    public void change(int option) {
        AirLine choosen = airlines.get(option - 1);
        LinkedList<Plane> allPlanes = choosen.getPlanes();
        showPlane(option);
        System.out.println("Змінити літак: ");
        int switched = in.nextInt();
        in.nextLine();
        if (switched > choosen.getNumOfCargoPalnes()) {
            LinkedList<PassangerPlane> planes = choosen.getPassPlanes();

            PassangerPlane plane = makePassPlane();
            planes.set(switched - choosen.getNumOfCargoPalnes() - 1, plane);
            allPlanes.set(switched - 1,plane);
            writerPass(planes);

        } else {
            LinkedList<CargoPlane> planes = choosen.getCargoPlanes();
            CargoPlane plane = makeCargoPlane();
            planes.set(switched - 1, plane);
            allPlanes.set(switched - 1, plane);
        }
        airlines.set(option-1,choosen);
        writeAir();
        System.out.println("Літак зміненно");
    }

    public void addPlane(int option) {
        AirLine choosen = airlines.get(option - 1);
        LinkedList<Plane> allPlanes = choosen.getPlanes();
        System.out.println("Додати пасажирський літак - 1, вантажний - 2");
        int switched = in.nextInt();
        in.nextLine();

        if (switched == 1) {
            PassangerPlane plane = makePassPlane();
            LinkedList<PassangerPlane> tmp = choosen.getPassPlanes();
            tmp.add(plane);
            choosen.setPassPlanes(tmp);
            allPlanes.add(plane);
            choosen.setPlanes(allPlanes);
            choosen.setNumOfPassangerPlane(choosen.getNumOfPassangerPlane() + 1);
            writerPass(tmp);


        } else {
            CargoPlane plane = makeCargoPlane();
            LinkedList<CargoPlane> tmp = choosen.getCargoPlanes();
            tmp.add(plane);
            choosen.setCargoPlanes(tmp);
            allPlanes.add(plane);
            choosen.setPlanes(allPlanes);
            choosen.setNumOfCargoPalnes(choosen.getNumOfCargoPalnes() + 1);
            writer(tmp);


        }
        airlines.set(option-1,choosen);
        writeAir();
        System.out.println("Літак додано");

    }
    public LinkedList<Plane> addPlaneTest(int option){
        int switched = 1;
        PassangerPlane plane = makePassPlaneTest();
        AirLine choosen = airlines.get(option - 1);
        LinkedList<Plane> allPlanes = choosen.getPlanes();
        allPlanes.add(plane);
        return allPlanes;


    }
    private CargoPlane makeCargoPlane() {
        in.nextLine();
        System.out.println("Введіть назву моделі: ");
        String model = in.nextLine();
        System.out.println("Введіть швидкість : ");
        double speed = in.nextDouble();
        System.out.println("Введіть дальність польоту: ");
        double range = in.nextDouble();
        System.out.println("Введіть вантажопідйомність: ");
        double capacity = in.nextDouble();
        System.out.println("Введіть параметри споживання пального: ");
        double fuelConsumption = in.nextDouble();
        in.nextLine();
        System.out.println("Введіть тип вантажо-підйомного обладнання: ");
        String typeOfLoad = in.nextLine();
        System.out.println("Введіть завантаженість: ");
        double loaded = in.nextDouble();
        if (loaded > capacity) {
            System.out.println("Завантаженісь більша за вантажопідйомність!!!");
            loaded = capacity;

        }
        CargoPlane plane = new CargoPlane(model, speed, range, capacity, fuelConsumption, typeOfLoad, loaded);
        //cargoPlane.add(plane);
        System.out.println("Ви додали вантажний літак");
        in.nextLine();
        return plane;

    }
    public CargoPlane makeCargoPlaneTest(){
        CargoPlane plane = new CargoPlane("a", 800, 8000, 40, 1500, "tl", 20);
        //cargoPlane.add(plane);
        System.out.println("Ви додали вантажний літак");

        return plane;

    }

    private PassangerPlane makePassPlane() {
        System.out.println("Введіть назву моделі: ");
        String model = in.nextLine();
        System.out.println("Введіть швидкість : ");
        double speed = in.nextDouble();
        System.out.println("Введіть дальність польоту: ");
        double range = in.nextDouble();
        System.out.println("Введіть вантажопідйомність: ");
        double capacity = in.nextDouble();
        System.out.println("Введіть параметри споживання пального: ");
        double fuelConsumption = in.nextDouble();
        System.out.println("Введіть к-сть пассажирських місць: ");
        int numOfSeats = in.nextInt();
        PassangerPlane plane = new PassangerPlane(model, speed, numOfSeats, range, capacity, fuelConsumption);
        //passPlane.add(plane);
        in.nextLine();
        return plane;

    }
    public PassangerPlane makePassPlaneTest(){
        PassangerPlane plane = new PassangerPlane("a",2000,300,5000,40,3000);
        return plane;
    }
    private void writer(LinkedList<CargoPlane> planes){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("CargoPlane.txt")))
        {
            oos.writeObject(planes);

        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
    private void writerPass(LinkedList<PassangerPlane> planes){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("PassPlane.txt")))
        {
            oos.writeObject(planes);
            logger.info("File writed");

        } catch (FileNotFoundException e) {
            logger.error("File not found.");
        } catch (IOException e) {
            logger.error("Error initializing stream.");
        }
    }
   private void writeAir(){
       try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Airline.txt"))) {

           airlines = ((LinkedList<AirLine>) ois.readObject());
           logger.info("File was opened");

       } catch (FileNotFoundException e) {
           logger.error("File not found.");
       } catch (IOException e) {
           logger.error("Error initializing stream.");
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
           logger.error("Class not found.");
       }

   }

    public void chooseAirline() {
    }
}
