package com.jedrzej.org;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Basket myBasket = new Basket();

        Item a = new Item("Can of corn[200g]", 0.99);
        Item b = new Item("Peanut Butter - Smoothy [1kg]", 5.99);
        Item c = new Item("Almond Milk - Gluten Free[1L]", 3.99);
        Item d = new Item("Flax seeds [400g]", 1.99);
        Item e = new Item("Whole frozen lobster [350g]", 12.99);

        myBasket.setItems(a, -2);
        myBasket.setItems(c, 1);
        myBasket.setItems(e, 0);
        myBasket.setItems(a, 2);
        myBasket.setItems(a,1);

        myBasket.deleteItems(c, 1);
        myBasket.deleteItems(c, 1);

        myBasket.displayBasket();
        System.out.println("Your total spendings are: " + myBasket.sumUp() +" $$$");

        //Testing on empty basket
        myBasket.deleteItems(a,3);
        myBasket.displayBasket();

    }
}
