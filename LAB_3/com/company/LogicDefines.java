package com.company;
/**
 * Файл у якому зібрані константи що визначають баланс гри
 */

public final class LogicDefines {
    /**
     * Базове здоров'я
     */
    public static final int BASE_HEALTH = 1000;
    /**
     * Базовий урон
     */
    public static final int BASE_DAMAGE = 100;
    /**
     * Базовий рандом цих значень, BASE_MARGIN * 100 відсотків у ту чи іншу сторону
     */
    public static final double  BASE_MARGIN = 0.4;

    // Поля множників для танків
    public static final double TANK_HEALTH_MULT = 1.5;
    public static final double TANK_DAMAGE_MULT = 0.8;


    // Поля назв класів
    public static final String STANDARD_CLASS = "Standard";
    public static final String DD_CLASS = "Dealer";
    public static final String TANK_CLASS = "Tank";
    public static final String HEALER_CLASS = "Healer";



    // Поля множників для ДД
    public static final double DD_HEALTH_MULT = 0.8;
    public static final double DD_DAMAGE_MULT = 2.0;
    // Шанс на те, що ДД втрапить у ціль. працює як цілочисельний правильний дріб
    public static final int DD_HIT_CHANCE = 80;
    public static final int DD_HIT_BOUND = 100;



}

