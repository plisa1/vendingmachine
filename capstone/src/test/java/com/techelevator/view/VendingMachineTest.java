package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class VendingMachineTest {

    VendingMachineCLI vendingMachineCLIInstance;
    private ByteArrayOutputStream output;


    @Before
    public void setup() {
       vendingMachineCLIInstance = new VendingMachineCLI();
        output = new ByteArrayOutputStream();

    }

    @Test
    public void does_vending_run() {



//
//
//
//        Assert.assertEquals();

    }

//    private Menu getMenuForTestingWithUserInput(String userInput) {
//        ByteArrayInputStream input = new ByteArrayInputStream(String.valueOf(userInput).getBytes());
//        return new Menu(input, output);
//    }
//
//    private Menu getMenuForTesting() {
//        return getMenuForTestingWithUserInput("1" + System.lineSeparator());
//    }
    // feed money test - balance counter?

    // item in stock?

    // correct change?

}
