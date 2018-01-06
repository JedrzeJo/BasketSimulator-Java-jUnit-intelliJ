package com.jedrzej.org;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    Basket testBasket = new Basket();
    Item testItem = new Item("random", 0.01);

    @Before
    public void cleanBasket() {
        testBasket = new Basket();
        testItem = new Item("random", 0.01);
    }

    @Test
    void setItems_shouldThrowIAEexception1() {
        try {
            testBasket.setItems(testItem, 0);
            fail("");
        } catch (IllegalArgumentException e) {
            System.out.println("Succes");
        }
    }

    @Test
    void setItems_shouldThrowIAEexception2() {
        try {
            testBasket.setItems(testItem, -2);
            fail("");
        } catch (IllegalArgumentException e) {
            System.out.println("Succes");
        }

    }

    @Test
    void setItems_validationOfAddingAmountFunction() {

        testBasket.setItems(testItem, 3);
        testBasket.displayBasket();
        testBasket.setItems(testItem, 5);
        testBasket.displayBasket();
        // assertEquals(8, testBasket.getAmount(testItem));
    }

    @Test
    void deleteItems() {
    }

    @Test
    void displayBasket() {
    }

    @Test
    void sumUp() {
    }
}