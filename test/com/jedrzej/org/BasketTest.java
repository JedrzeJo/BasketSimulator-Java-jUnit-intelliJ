package com.jedrzej.org;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    Basket testBasket = new Basket();
    Item testItem = new Item("random", 0.01);

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
        testBasket.setItems(testItem, 5);
        assertEquals(8, testBasket.getAmount(testItem));
    }

    @Test
    void deleteItem_TryingToDeleteNotExistingItem() {
        try {
            testBasket.deleteItems(testItem, 5);
            fail("");
        } catch (NullPointerException e) {
            System.out.println("Suceed.");
        }
    }

    @Test
    void deleteItem_TryingToDeleteMoreInstancesOfItemThanYouHave() {
        try {
            testBasket.setItems(testItem, 3);
            testBasket.deleteItems(testItem, 4);
            fail("");
        } catch (IllegalArgumentException e) {
            System.out.println("Suceed.");
        }
    }

    @Test
    void deleteItems_validationOfDeletingCertainAmount() {
        testBasket.setItems(testItem, 11);
        testBasket.deleteItems(testItem,9);
        assertEquals(2, testBasket.getAmount(testItem));
    }

    @Test
    void deleteItems_deletingEqualAmountToAmountInBasket() {
        testBasket.setItems(testItem, 7);
        testBasket.setItems(testItem, 2);
        testBasket.deleteItems(testItem,9);
        assertEquals(0, testBasket.getAmount(testItem));
    }

    @Test
    void sumUp() {
        testBasket.setItems(testItem, 13);
        assertEquals(0.13, testBasket.sumUp());
    }
}