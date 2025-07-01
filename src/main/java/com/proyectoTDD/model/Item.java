package com.proyectoTDD.model;

public class Item {
    private int id;
    private String size;
    private String name;
    private int stock;

    //Constructor

    public Item() {
    }

    public Item(int id, String size, String name, int stock) {
        this.id = id;
        this.size = size;
        this.name = name;
        this.stock = stock;
    }

    //Getters

    public int getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
