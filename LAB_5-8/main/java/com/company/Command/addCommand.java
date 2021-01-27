package com.company.Command;

import com.company.Selector.AirMenu;

public class addCommand implements Command {
    private AirMenu data;

    public addCommand(AirMenu data) {
        this.data = data;
    }

    @Override
    public void execute(int option) {
        data.makeCompany();

    }
}
