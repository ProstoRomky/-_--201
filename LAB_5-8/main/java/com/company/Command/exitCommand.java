package com.company.Command;

import com.company.Selector.AirMenu;

public class exitCommand implements Command {
    private AirMenu data;

    public exitCommand(AirMenu data) {
        this.data = data;
    }
    @Override
    public void execute(int option) {
        data.exit();

    }
}
