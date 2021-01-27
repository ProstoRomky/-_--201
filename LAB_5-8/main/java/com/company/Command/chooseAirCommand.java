package com.company.Command;

import com.company.Selector.AirMenu;

public class chooseAirCommand implements Command{
    private AirMenu data;

    public chooseAirCommand(AirMenu data) {
        this.data = data;
    }

    @Override
    public void execute(int option) {
        data.chooseAirline();

    }
}
