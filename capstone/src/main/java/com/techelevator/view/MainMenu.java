package com.techelevator.view;

import java.io.*;
import java.util.*;

//import static com.techelevator.view.Inventory.currentStock;
//import static com.techelevator.view.Inventory.result;

public class MainMenu {

    private static final String DISPLAY = "1. Display Vending Machine Items";
    private static final String PURCHASE = "2. Purchase";
    private static final String EXIT = "3. Exit";


    private PrintWriter out;
    private Scanner in;
//    public String input;
//    String output;
    Inventory inventory = new Inventory();

    public MainMenu(InputStream in, PrintStream out) {

        this.out = new PrintWriter(out);
        this.in = new Scanner(in);

    }

    public MainMenu() {

    }

    public String getItemID() {
        System.out.println("Enter your selection");
        return in.nextLine();
    }

    public String mainMenuDisplay() {
        System.out.println("----- Welcome to A&L's Vending Machine! -----");

//        Scanner userInput = new Scanner(System.in);
        //display input

        System.out.println(DISPLAY);
        System.out.println(PURCHASE);
        System.out.println(EXIT);
        System.out.println("Choose: [1], [2], [3]");
//        int value = Integer.parseInt(userInput.nextLine());
        return in.nextLine();
    }


    public String purchaseMenuDisplay() {

        System.out.println("[1] Feed Money");
        System.out.println("[2] Select Product");
        System.out.println("[3] Finish Transaction");

        return in.nextLine();
    }

    public String selectFeedMoney(){
        System.out.println("Machine Accepts $1, $5, and $10 bills");
        System.out.println("Enter [1]$1, [5]$5, or [10]$10 bills: ");
        System.out.println("Press [0] to go back to Purchase Menu");
        return in.nextLine();
    }
}

