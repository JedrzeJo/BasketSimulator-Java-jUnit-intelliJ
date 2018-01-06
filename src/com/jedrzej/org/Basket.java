package com.jedrzej.org;


import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Basket {

    private Map<Item, Integer> mapOfItems = new HashMap<>();

    //DOMAIN CONSTRUCTOR
    public Basket() {
    }

    //CLEARS THE BASKET
    public void clearBasket() {
        this.mapOfItems.clear();
    }

    public int getAmount(Item local){
        return this.mapOfItems.getOrDefault(local, 0);
    }


    //MULTI SETTER to basket METHOD
    public void setItems(Item keyAtribute, Integer amount) {
        if (amount <= 0) {
            //System.out.println(keyAtribute.getItemName() + " Failure during adding. Reason : Impossible to add amount lower than 1.");
            throw new IllegalArgumentException(String.format("Impossible to add %d products!", amount));
        }
        //adding amount to products which already were in basket
        else if (this.mapOfItems.getOrDefault(keyAtribute, 0) > 0) {
            Integer localResult = this.mapOfItems.getOrDefault(keyAtribute, 0) + amount;
            this.mapOfItems.replace(keyAtribute, localResult);
        } /*else {
            this.mapOfItems.put(keyAtribute, amount);
            System.out.println(keyAtribute.getItemName() + " added to Your basket.");
        }*/
        ;
    }

    //MULTI DELETE METHOD
    public void deleteItems(Item keyAtribute, Integer amount) {

        if (mapOfItems.containsKey(keyAtribute) == false) {
            //System.out.println("You don't have such item in Your basket.");
            throw new NullPointerException(String.format("Cannot delete not existing object."));
        } else if (this.mapOfItems.getOrDefault(keyAtribute, 0) < amount)  //Ensure that map always has a value
        {
            //System.out.println("You cannot remove more products than You have.");
            throw new IllegalArgumentException(String.format("Cannot remove %d products.", amount));
        } else if (this.mapOfItems.getOrDefault(keyAtribute, 0) == amount) {
            this.mapOfItems.remove(keyAtribute);
            System.out.println("Product " + keyAtribute.getItemName() + " completely removed from Your basket");
        } else {
            int localResult = this.mapOfItems.getOrDefault(keyAtribute, 0) - amount;
            this.setItems(keyAtribute, localResult);
            System.out.println(keyAtribute.getItemName() + " removed in amount of " + amount);
        }

    }

    //DISPLAYING BASKET METHOD  //NO SHIT
    public void displayBasket() {
        try {
            if (this.mapOfItems.isEmpty() == true) {
                throw new Exception();
            } else {
                for (Map.Entry<Item, Integer> entry : this.mapOfItems.entrySet()) {
                    double localPrice = entry.getKey().getPrice();
                    Integer localAmount = entry.getValue();
                    String localName = entry.getKey().getItemName();
                    System.out.println(localName + " Amount: [" + localAmount + "] Price each: " + localPrice + " $");
                }
            }
        } catch (Exception e) {
            System.out.println("Basket is empty.");
        }
        ;

    }

    //COUNTING SUM OF YOUR ORDER
    public double sumUp() {
        double sum = 0;
        for (Map.Entry<Item, Integer> entry : mapOfItems.entrySet()) {
            double localSUM = entry.getValue() * entry.getKey().getPrice();
            sum += localSUM;
        }
        sum *= 100;
        sum = Math.round(sum);
        sum /= 100;
        return sum;
    }
}

