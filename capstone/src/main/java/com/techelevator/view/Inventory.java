package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import com.techelevator.Chips;
//import com.techelevator.Drink;
//import com.techelevator.Gum;
//import com.techelevator.VendingItem;

public class Inventory {

    private List<Item> itemsListed;
    File newFile = new File("vendingmachine.csv");

    public Inventory() {

        itemsListed = new ArrayList<>();



        try {
            Scanner scan = new Scanner(newFile);
            while (scan.hasNextLine()) {
                String stringLines = scan.nextLine();
                String[] itemProperties = stringLines.split("\\|");
                String ID = itemProperties[0];
                String name = itemProperties[1];
                double price = Double.parseDouble(itemProperties[2]);
                String type = itemProperties[3];
                final int DEFAULT_INVENTORY_COUNT = 5;

//                Item chip = new Chips("1", "Test1", 0.50, "Typetest1", 5);
//                Item drink = new Drink("2", "Test2", 1.00, "Typetest2", 3);
//
//                List<Item> itemsListedTest = new ArrayList<>();
//                itemsListedTest.add(chip);
//                itemsListedTest.add(drink);
//
//                System.out.println("Item index 0: " + itemsListedTest.get(0).getName());
//                System.out.println("Item index 1: " + itemsListedTest.get(1).getName());

                //adding information to list
                if (type.equals("Chip")) {
                    itemsListed.add(new Chips(ID, name, price, type, DEFAULT_INVENTORY_COUNT));
                } else if (type.equals("Candy")) {
                    itemsListed.add(new Candy(ID, name, price, type, DEFAULT_INVENTORY_COUNT));
                } else if (type.equals("Drink")) {
                    itemsListed.add(new Drink(ID, name, price, type, DEFAULT_INVENTORY_COUNT));
                } else if (type.equals("Gum")) {
                    itemsListed.add(new Gum(ID, name, price, type, DEFAULT_INVENTORY_COUNT));
                }
            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
            //DO NOTHING, NO FILE, NO INVENTORY
        }
    }

    public List<Item> getItemsListed() {
        return itemsListed;
    }

}

