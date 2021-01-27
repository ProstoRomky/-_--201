package com.company.droid;

import com.company.LogicDefines;
import java.util.Random;

/**
 * Опис нащадка класу Droid типу ДД, тобто одиниця з підвищеним damage
 * В конструкторі до базових значень health і damage прикладаються
 * множники специфічні до ДД
 * І базові значення статів, і множники знаходять у LogicDefines
 */

public class Dealer extends Droid {

    private String droidClass = LogicDefines.DD_CLASS;

    public Dealer(String droidName, int droidHealth, int droidDamage) {
        super(droidName, (int)(droidHealth * LogicDefines.DD_HEALTH_MULT), (int)(droidDamage * LogicDefines.DD_DAMAGE_MULT));
    }

    public String getDroidClass() {return droidClass;}

    /**
     * Атака ДД дроіда, має шанс промазати, який описаний у LogicDefines
     * @param target ціль атаки, об'єкт класу дроід або нащадок
     */
    public void attack(Droid target) {
        Random chance = new Random();
        if (LogicDefines.DD_HIT_CHANCE > chance.nextInt(LogicDefines.DD_HIT_BOUND)) {
            target.setHealth(target.getHealth() - this.getDamage());
        }
    }

}

