package com.company.Command;

import com.company.Selector.AirMenu;

public class changeCommand implements Command {
    private AirMenu data;

    public changeCommand(AirMenu data) {
        this.data = data;
    }

    @Override
    public void execute(int option) {
        data.change(option);

    }
}

