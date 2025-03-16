package com.t7apklym8.t7world;

public class ShopItem {
    private int id;
    private String name;
    private int price;
    private String type;

    public ShopItem(int id, String name, int price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}