package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class InventoryTest {

    Inventory inventoryTestInstance;

    @Before
    public void setup () {
        inventoryTestInstance = new Inventory();
    }


    @Test
    public void does_item_stock_equal_16() {

        Assert.assertEquals(16, inventoryTestInstance.getItemsListed().size());

    }

//    @Test
//    public void catch_exception() {
//
//        File someFile = new File("sometext.txt");
//
//        Assert.assertEquals(false, inventoryTestInstance.getItemsListed(someFile.exists()));
//
//    }

}
