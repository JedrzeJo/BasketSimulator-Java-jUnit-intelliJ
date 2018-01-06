package com.jedrzej.org;

public class Item {
    private String ItemName;
    private double Price;

    public Item(String itemName, double price) {
        ItemName = itemName;
        Price = price;
    }

    public String getItemName(){
        return this.ItemName;
    }

    public double getPrice(){
        return this.Price;
    }

    public void DisplayItemInfo(){
        System.out.println(this.ItemName +" \tprice: "+this.Price+"$");
    }

}

