package com.company.droid;

import com.company.LogicDefines;

/**
 * Клас що наслідується
 * Поля класів очевидні
 * Геттери і сеттери також
 * Лише health змінюється, тому лише у цього поля є сеттер
 */

public class Droid {
    private String name;
    private String droidClass = LogicDefines.STANDARD_CLASS;
    private int health;
    private int damage;



    public Droid(String droidName, int droidHealth, int droidDamage) {
        name = droidName;
        health = droidHealth;
        damage = droidDamage;
    }

    public void attack(Droid target) {
        target.setHealth(target.getHealth() - this.getDamage());
    }

    public String getDroidClass() {return droidClass;}

    public String getName() {return name;}

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

