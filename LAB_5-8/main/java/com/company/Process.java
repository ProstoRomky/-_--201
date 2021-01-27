package com.company;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;
import com.company.AirLine.AirLine;
import com.company.Command.*;
import com.company.Plane.CargoPlane;
import com.company.Plane.PassangerPlane;
import com.company.Selector.AirMenu;
import com.company.Selector.Selector;
import java.util.*;
public class Process {
    Scanner in = new Scanner(System.in);
    AirMenu data = new AirMenu();
    Selector selector = switcher(data);
    Menu menu = new Menu();
    static Logger logger = Logger.getLogger(Main.class);

    static {
        DOMConfigurator.configure("log4j.xml");
    }


    public void startMenu(){
        data.init_Planes();
        data.init_AirLine();

        while(true){

            menu.showStartMenu();
            logger.info("Main menu is called.");
            int option = in.nextInt();
            switch (option){
                case 1:
                    data.show();
                    option=in.nextInt();
                    data.chooseAirline();
                    System.out.println();
                    while (true) {
                        menu.showMenu();
                        int optionMenu = in.nextInt();
                        switch (optionMenu) {

                            case 1:
                                selector.useSort(option);
                                System.out.println();
                                continue;
                            case 2:
                                data.showPlane(option);
                                System.out.println();
                                continue;
                            case 3:
                                data.addPlane(option);
                                System.out.println();
                                continue;
                            case 4:
                                selector.useDelete(option);
                                System.out.println();
                                continue;
                            case 5:
                                selector.useChange(option);
                                System.out.println();
                                continue;
                            case 6:
                                data.countPlane(option);
                                System.out.println();
                                continue;
                            case 7:
                                data.diap(option);
                                System.out.println();
                                continue;
                            case 8:
                                selector.useExit(option);
                                System.out.println();
                                break;
                        }
                        break;

                    }
                    continue;


                case 2:
                    System.out.println();
                    selector.useAdd(option);
                    continue;

                case 3:
                    System.out.println();
                    selector.useExit(option);
                    break;
            }
            break;

        }
    }
    public static Selector switcher(AirMenu data){

        Command sort = new sortCommand(data);
        Command add = new addCommand(data);
        Command choose = new chooseAirCommand(data);
        Command delete = new deleteCommand(data);
        Command exit = new exitCommand(data);
        Command change = new changeCommand(data);
        Command show = new changeCommand(data);
        Command count = new changeCommand(data);
        Selector selector = new Selector(choose,add,delete,exit,sort,change,show,count);
        return selector;
    }
}
