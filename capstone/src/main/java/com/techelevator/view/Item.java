package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Item {

    private static final int DEFAULT_INVENTORY_COUNT = 5;

    private String id;
    private String name;
    private double cost;
    private String snackType;
    private int quantity;
    private String sound;

    public Item() {
        
    }

// quantity

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public String getSnackType() {
        return snackType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSound() {
        return sound;
    }

    //constructor
    public Item(String id, String name, double cost, String snackType, int quantity, String sound) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.snackType = snackType;
        this.quantity = quantity;

        this.sound = sound;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Cost: " + cost + "\n";
    }

    //a method that checks if item the user input in object o is equal to what's in inventory
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId() == item.getId();
    }
}
