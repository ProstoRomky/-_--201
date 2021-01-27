package com.company.Command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
 public Menu menu = new Menu();
    @Test
    void showMenu() {
        menu.showMenu();
    }

    @Test
    void showStartMenu() {
        menu.showStartMenu();
    }
}