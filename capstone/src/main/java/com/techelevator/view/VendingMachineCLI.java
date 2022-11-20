package com.techelevator.view;

import java.io.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class VendingMachineCLI {

    private MainMenu menu;
    private Inventory inventory;

    List<Item> itemList;
    List<Item> purchaseItems = new ArrayList<>();
    List<Double> purchaseBalance = new ArrayList<>();
    NumberFormat format = NumberFormat.getCurrencyInstance();

    double depositBalance = 0.00;

    public VendingMachineCLI(MainMenu menu) {
        this.menu = menu;
        this.inventory = new Inventory();
        itemList = this.inventory.getItemsListed();
    }

    public VendingMachineCLI() {

    }

    public void run() {

        try {
            File transactionLog = new File("Log.txt");
            if (!transactionLog.exists()) {
                transactionLog.createNewFile();
            }
            PrintWriter pw = new PrintWriter(transactionLog);
            DateFormat dateFormat = new SimpleDateFormat();
            Date date = new Date();

            //main menu - display
            String mainMenuChoice = menu.mainMenuDisplay();
            while (!mainMenuChoice.equals("2")) {
                if (mainMenuChoice.equals("1")) {
                    for (int i = 0; i < itemList.size(); i++) {
                        System.out.println(itemList.get(i).getId() + ", " + itemList.get(i).getName() + ", "
                                + itemList.get(i).getCost() + ", " + "Quantity Left: " + itemList.get(i).getQuantity());
                    }
                } else {
                    //DO NOTHING
                }
                mainMenuChoice = menu.mainMenuDisplay();
            }

            //purchase menu

            // feed money
            String purchaseMenuChoice = menu.purchaseMenuDisplay();
            while (!purchaseMenuChoice.equals("3")) {
                if (purchaseMenuChoice.equals("1")) {    //person chooses to stick money into machine
//                    String moneyFeed = menu.selectFeedMoney();
//                    menu.purchaseMenuDisplay();

                    String getMoneyFeed = menu.selectFeedMoney();
                    while (!getMoneyFeed.equals("0")) {
                        if (getMoneyFeed.equals("1")) {
                            depositBalance += 1;
                            purchaseBalance.add(depositBalance);
                            pw.println(dateFormat.format(date) + " FEED MONEY: " + "$1.00" + " " + format.format(depositBalance));
                            System.out.println("Your balance is: " + format.format(depositBalance));
                        } else if (getMoneyFeed.equals("5")) {
                            depositBalance += 5;
                            purchaseBalance.add(depositBalance);
                            pw.println(dateFormat.format(date) + " FEED MONEY: " + "$5.00" + " " + format.format(depositBalance));
                            System.out.println("Your balance is: " + format.format(depositBalance));
                        } else if (getMoneyFeed.equals("10")) {
                            depositBalance += 10;
                            purchaseBalance.add(depositBalance);
                            pw.println(dateFormat.format(date) + " FEED MONEY: " + "$10.00" + " " + format.format(depositBalance));
                            System.out.println("Your balance is: " + format.format(depositBalance));
                        } else {
                            System.out.println("Invalid selection. Please try again.");
                        }
                        getMoneyFeed = menu.selectFeedMoney();
                    }

                } else if (purchaseMenuChoice.equals("2")) {

                    //select product
                    String getIDFromMenu = menu.getItemID();
                    Boolean isIdValid = false;
                    for (int i = 0; i < itemList.size(); i++) {
                        if (getIDFromMenu.equalsIgnoreCase(itemList.get(i).getId())) {
                            isIdValid = true;
                            String itemID = itemList.get(i).getName();
                            double itemCost = itemList.get(i).getCost();
                            int itemAmount = itemList.get(i).getQuantity();

                            boolean itemInStock = false;
                            if (itemAmount > 0) {
                                itemInStock = true;
                            } else {
                                System.out.println("Item you selected is out of stock. Pick another.");
                            }
                            boolean enoughToPurchase = false;

                            if (itemCost <= depositBalance) {
                                enoughToPurchase = true;
                                depositBalance = depositBalance - itemCost;
                                purchaseBalance.add(depositBalance);
//                                //come back later for customer balance inside vending machine
                                //call calculator method later to update customer balance

                                itemList.get(i).setQuantity(itemList.get(i).getQuantity() - 1);
                                System.out.println(itemList.get(i).getSound());
                                purchaseItems.add(itemList.get(i));

                                //log purchases
                                System.out.println("You purchased " + itemList.get(i).getName() + " & your balance is " + format.format(depositBalance));
                            } else {
                                System.out.println("Not enough. Select [1] to Feed Money or [2] to Select Product: ");
                            }
                        }
                    }
                    if (isIdValid == false) {
                        System.out.println("Invalid ID number. Please re-enter: ");
                    }
                }
                purchaseMenuChoice = menu.purchaseMenuDisplay();


            }
            //End transaction menu

            for (int i = 0; i < purchaseItems.size(); i++) {
                pw.print(dateFormat.format(date) + " " + purchaseItems.get(i).getName() +
                        " " + purchaseItems.get(i).getId() + ": "
                        + "" + format.format(purchaseItems.get(i).getCost()) + " " + format.format(purchaseBalance.get(i + 1)));
                pw.println();
            }

            pw.print(dateFormat.format(date) + " GIVE CHANGE: " + format.format(depositBalance));

            //calculate change
            depositBalance = depositBalance * 100;
            int quarter = (int) (depositBalance / 25);
            depositBalance = depositBalance % 25;
            int dime = (int) (depositBalance / 10);
            depositBalance = depositBalance % 10;
            int nickle = (int) (depositBalance / 5);
            depositBalance = depositBalance % 5;

            System.out.println("Your change is: " + quarter + " quarters, " + dime + " dimes, " + nickle + " nickels");

            pw.flush();
            pw.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        MainMenu menu = new MainMenu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }


}


