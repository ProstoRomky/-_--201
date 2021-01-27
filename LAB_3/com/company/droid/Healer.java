package com.company.droid;

import com.company.LogicDefines;

/**
 * Опис нащадка класу дроід який лікує інші дроіди
 * правильність цілі забезпучується логікою написаною в main()
 */

public class Healer extends Droid {

    private String droidClass = LogicDefines.HEALER_CLASS;

    public Healer(String droidName, int droidHealth, int droidDamage) {
        super(droidName, droidHealth, droidDamage);
    }

    public String getDroidClass() {return droidClass;}



    public void attack(Droid target) {
        target.setHealth(target.getHealth() + this.getDamage());
    }

}

