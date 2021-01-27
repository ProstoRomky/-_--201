package com.company.Command;

import com.company.Selector.AirMenu;

public class sortCommand implements Command {
    private AirMenu data;

    public sortCommand(AirMenu data) {
        this.data = data;
    }

    @Override
    public void execute(int option) {
        data.sortPlane(option);

    }
}
