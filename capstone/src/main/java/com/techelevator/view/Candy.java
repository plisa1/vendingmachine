package com.techelevator.view;

import com.techelevator.view.Item;

public class Candy extends Item {
    public Candy(String id, String name, Double cost, String snackType, int quantity) {
        super(id, name, cost, snackType, quantity, "Munch Munch, Yum!");
    }

    public Candy() {
        super();
    }
}
