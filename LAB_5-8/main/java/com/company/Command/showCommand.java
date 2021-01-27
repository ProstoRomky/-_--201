package com.company.Command;

import com.company.Selector.AirMenu;

public class showCommand implements Command {
    private AirMenu data;

    public showCommand(AirMenu data) {
        this.data = data;
    }

    @Override
    public void execute(int option) {
        data.show();

    }
}
