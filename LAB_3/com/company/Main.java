package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.company.droid.*;

/**
 * Клас в якому визначена основна логіка програми
 */

public class Main {
    public static int selector;
    public static Scanner scanner = new Scanner(System.in);
    public static Random rand = new Random();
    /**
     * Пул створених дроїдів, після використання елемент видаляється
     */
    public static ArrayList<Droid> droid_pool;
    /**
     * Ростер першої команди
     */
    public static ArrayList<Droid> team_red;
    /**
     * Ростер другої команди
     */
    public static ArrayList<Droid> team_blue;

    /**
     * Реалізії виборів з Menu()
     */
    public static void main(String[] args) {
        droid_pool = new ArrayList<Droid>();
        team_red = new ArrayList<Droid>();
        team_blue = new ArrayList<Droid>();

        while(true) {
            selector = menu();
            switch(selector) {
                case (1):
                    System.out.println();
                    System.out.println("Available droid types:");
                    System.out.println("1 - damage dealer");
                    System.out.println("2 - tank");
                    System.out.println("3 - healer");
                    droid_pool.add(createDroid());
                    break;
                case (2):
                    poolOut(droid_pool);
                    break;
                case (3):
                    setupTeams(1);
                    fightStart();
                    break;
                case (4):
                    droid_pool.add(createDroidAutomated("Dealer red", 1));
                    droid_pool.add(createDroidAutomated("Dealer blue", 1));
                    setupTeamsAutomated(1);
                    fightStart();
                    break;
                case (5):
                    System.out.println("Enter team size :");
                    selector = scanner.nextInt();
                    setupTeams(selector);
                    fightStart();
                    break;
                case(6):
                    droid_pool.add(createDroidAutomated("Dealer red", 1));
                    droid_pool.add(createDroidAutomated("Tank red 1", 2));
                    droid_pool.add(createDroidAutomated("Tank red 2", 2));
                    droid_pool.add(createDroidAutomated("Healer red", 3));
                    droid_pool.add(createDroidAutomated("Dealer blue", 1));
                    droid_pool.add(createDroidAutomated("Tank blue 1", 2));
                    droid_pool.add(createDroidAutomated("Tank blue 2", 2));
                    droid_pool.add(createDroidAutomated("Healer blue", 3));
                    setupTeamsAutomated(4);
                    fightStart();
                    break;
                case (7):
                    return;
            }
        }

    }


    /**
     * Функція що реалізовує меню та вибір елемента з меню
     * @return номер опції яку було вибрано
     */
    public static int menu() {
        System.out.println();
        System.out.println("Input what you want to do: ");
        System.out.println("1 - Create droid");
        System.out.println("2 - Print list of available droids");
        System.out.println("3 - Start a 1v1 fight (manual team setup)");
        System.out.println("4 - Start a 1v1 fight (automated team setup)");
        System.out.println("5 - Start a teamfight (manual team setup)");
        System.out.println("6 - Start a teamfight (automated team setup)");
        System.out.println("7 - Exit the program");
        selector = scanner.nextInt();
        return selector;
    }

    /**
     * Функція що створює об'єкт одного з трьох класів
     * @return Об'єкт класу дроід
     */

    public static Droid createDroid() {
        String str = new String();
        Droid droid = null;
        int randomized_health = (int)(LogicDefines.BASE_HEALTH * (1 - LogicDefines.BASE_MARGIN)) +
                rand.nextInt((int)(LogicDefines.BASE_HEALTH * LogicDefines.BASE_MARGIN * 2));
        int randomized_damage = (int)(LogicDefines.BASE_DAMAGE * (1 - LogicDefines.BASE_MARGIN)) +
                rand.nextInt((int)(LogicDefines.BASE_DAMAGE * LogicDefines.BASE_MARGIN * 2));

        do
        {System.out.print("\nChoose from the available droid types: ");
            selector = scanner.nextInt();
        } while (selector < 1 || selector > 3);
        scanner.nextLine();
        System.out.print("Input droid name: ");
        str = scanner.nextLine();
        switch (selector) {
            case (1):
                droid = new Dealer(str, randomized_health , randomized_damage);
                break;
            case (2):
                droid = new Tank(str, randomized_health, randomized_damage);
                break;
            case (3):
                droid = new Healer(str, randomized_health, randomized_damage);
                break;
        }
        return droid;
    }

    /**
     * Автоматизована версія функції createDroid()
     * @param name Ім'я об'єкту що буде створений
     * @param droidtype Тип дроіду що буде створений
     * @return Об'єкт класу дроід
     */
    public static Droid createDroidAutomated(String name, int droidtype) {
        Droid droid = null;
        int randomized_health = (int)(LogicDefines.BASE_HEALTH * (1 - LogicDefines.BASE_MARGIN)) +
                rand.nextInt((int)(LogicDefines.BASE_HEALTH * LogicDefines.BASE_MARGIN * 2));
        int randomized_damage = (int)(LogicDefines.BASE_DAMAGE * (1 - LogicDefines.BASE_MARGIN)) +
                rand.nextInt((int)(LogicDefines.BASE_DAMAGE * LogicDefines.BASE_MARGIN * 2));
        switch (droidtype) {
            case (1):
                droid = new Dealer(name, randomized_health , randomized_damage);
                break;
            case (2):
                droid = new Tank(name, randomized_health, randomized_damage);
                break;
            case (3):
                droid = new Healer(name, randomized_health, randomized_damage);
                break;
        }
        return droid;
    }

    /**
     * Функція що форматовано виводить інформацію про об'єкти в ArrayList'ах (пул і ростери)
     * @param list ArrayList який буде виведено
     */

    public static void poolOut(ArrayList<Droid> list) {
        System.out.format("№  %-10s %-15s %-10s %-10s %n", "Class", "Name", "Health", "Damage");
        for (int i = 0; i < list.size(); i++) {
            System.out.format("%d  %-10s %-15s %-10d %-10d %n", i + 1, list.get(i).getDroidClass(), list.get(i).getName(),
                    list.get(i).getHealth(), list.get(i).getDamage()) ;
        }
        System.out.println();
        return;
    }

    /**
     * Функція що розкидує об'єкти з пулу по командах за вибором користувача
     * @param team_size розмір команд що будуть створюватися
     */

    public static void setupTeams(int team_size) {
        System.out.println();
        if (team_size == 1) System.out.println("1 on 1 team setup.");
        System.out.println("Available droids:");
        poolOut(droid_pool);
        for (int i = 0; i < team_size; i++) {
            System.out.println("Choose a fighter for team Red: ");
            selector = scanner.nextInt();
            team_red.add(droid_pool.get(selector - 1));
            droid_pool.remove(selector - 1);
            System.out.println("Updated pool:");
            poolOut(droid_pool);
        }
        System.out.println("Finalized team Red:");
        poolOut(team_red);
        for (int i = 0; i < team_size; i++) {
            System.out.println("Choose a fighter for team Blue: ");
            selector = scanner.nextInt();
            team_blue.add(droid_pool.get(selector - 1));
            droid_pool.remove(selector - 1);
            System.out.println("Updated pool:\n");
            poolOut(droid_pool);
        }
        System.out.println("Finalized team Blue:");
        poolOut(team_blue);

        System.out.println("Team setup finalized");
    }

    /**
     * Автоматизований setupTeams для швидкого дебагінга та презентації викладачеві
     * @param team_size розмір команд що будуть створюватися
     */

    public static void setupTeamsAutomated(int team_size) {
        for (int cnt = 0; cnt < team_size; cnt++) {
            team_red.add(droid_pool.get(0));
            droid_pool.remove(0);
        }
        for (int cnt = 0; cnt < team_size; cnt++) {
            team_blue.add(droid_pool.get(0));
            droid_pool.remove(0);
        }
        System.out.println("Team setup finalized");
        System.out.println("Finalized team Red:");
        poolOut(team_red);
        System.out.println("Finalized team Blue:");
        poolOut(team_blue);
    }

    /**
     * Метод що ініціалізує битву
     */

    public static void fightStart() {
        for (int cnt = 1;(team_red.size() != 0) && (team_blue.size() != 0); cnt++) {
            fightTick();

            System.out.println("TURN " + cnt);
            System.out.println("Team red roster:");
            poolOut(team_red);
            System.out.println("Team blue roster:");
            poolOut(team_blue);
        }
        if (team_red.size() == 0 && team_blue.size() == 0) {
            System.out.println("Neither team has won.");
        } else if (team_red.size() == 0) {
            System.out.println("Blue team has won!");
        } else {
            System.out.println("Red team has won!");

        }
        return;
    }

    /**
     * Метод в якому реалізована логіка бойової системи
     * Команди ходять "одночасно", мертві дроіди видаляються лише після того
     * як обидві команди зроблять свій хід
     */

    private static void fightTick() {
        int randslave;

        // TEAM RED TURN

        for (int i = 0; i < team_red.size(); i++) {

            if (team_red.get(i).getDroidClass().equals(LogicDefines.HEALER_CLASS)) {
                do {
                    randslave = rand.nextInt(team_red.size());
                } while (randslave == i);
                team_red.get(i).attack(team_red.get(randslave));
            } else {
                randslave = rand.nextInt(team_blue.size());
                team_red.get(i).attack(team_blue.get(randslave));
            }
        }

        // TEAM BLUE TURN

        for (int i = 0; i < team_blue.size(); i++) {

            if (team_blue.get(i).getDroidClass().equals(LogicDefines.HEALER_CLASS)) {
                do {
                    randslave = rand.nextInt(team_blue.size());
                } while (randslave == i);
                team_blue.get(i).attack(team_blue.get(randslave));
            } else {
                randslave = rand.nextInt(team_red.size());
                team_blue.get(i).attack(team_red.get(randslave));

            }
        }

        // ELIMINATIONS TURN
        for (int cnt = 0; cnt < team_red.size(); cnt++) {
            if (team_red.get(cnt).getHealth() <= 0) team_red.remove(cnt);
        }
        for (int cnt = 0; cnt < team_blue.size(); cnt++) {
            if (team_blue.get(cnt).getHealth() <= 0) team_blue.remove(cnt);
        }
    }
}

