package com.company.Command;

import com.company.Selector.AirMenu;

public class deleteCommand implements Command{
    private AirMenu data;

    public deleteCommand(AirMenu data) {
        this.data = data;
    }

    @Override
    public void execute(int option) {
        data.deleteSmth(option);

    }
}

