package com.company.droid;

import com.company.LogicDefines;

/**
 * Опис нащадка класу Droid типу танк
 * В конструкторі до базових значень health і damage прикладаються
 * множники специфічні до танків
 * І базові значення статів, і множники знаходять у LogicDefines
 */

public class Tank extends Droid {

    private String droidClass = LogicDefines.TANK_CLASS;

    public Tank(String droidName, int droidHealth, int droidDamage) {
        super(droidName, (int)(droidHealth * LogicDefines.TANK_HEALTH_MULT), (int)(droidDamage * LogicDefines.TANK_DAMAGE_MULT));
    }

    public String getDroidClass() {return droidClass;}

    /**
     * Базова атака
     * @param target об'єкт класу дроід або нащадок
     */
    public void attack(Droid target) {
        target.setHealth(target.getHealth() - this.getDamage());
    }

}

