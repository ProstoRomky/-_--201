package com.company.Selector;

import com.company.Command.Command;

public class Selector {
    private Command chooseAir, add, delete, exit, sort, change, show,count;

    public Selector(Command chooseAir, Command add, Command delete, Command exit, Command sort, Command change, Command show, Command count) {
        this.chooseAir = chooseAir;
        this.add = add;
        this.delete = delete;
        this.exit = exit;
        this.sort = sort;
        this.change = change;
        this.show = show;
        this.count = count;
    }

    public void useShow(int option) {
        show.execute(option);
    }

    public void useChooseAir(int option) {
        chooseAir.execute(option);
    }

    public void useAdd(int option) {
        add.execute(option);
    }

    public void useDelete(int option) {
        delete.execute(option);
    }

    public void useExit(int option) {
        exit.execute(option);
    }

    public void useSort(int option) {
        sort.execute(option);
    }

    public void useChange(int option) {
        change.execute(option);
    }
    public void useCount(int option) {
        count.execute(option);
    }

}
