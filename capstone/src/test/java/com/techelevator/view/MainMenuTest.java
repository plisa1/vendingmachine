package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class MainMenuTest {
    MainMenu menu;
    List<Item> itemList;
    MainMenu mainMenuTest;

    @Before
    public void setup() {
        mainMenuTest = new MainMenu();
        menu = new MainMenu();
    }



//    @Test
//    public void is_there_input_output() {


//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//    }

}
