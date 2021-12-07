package com.codegym.Unit;

public class Drink {
    private int id;
    private String name;
    private String materials;
    private long cost;
    private long price;
    private int status;

    public Drink() {
    }

    public Drink(int id, String name, String materials, long cost, long price, int status) {
        this.id = id;
        this.name = name;
        this.materials = materials;
        this.cost = cost;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String strStatus= null;
        if (this.status == 1)
            strStatus= "Selling";
        else
            strStatus= "Sold out";
        return String.format("ID: %d\nName: %s\nMaterials: %s\nCost: %d VND\nPrice: %d VND\nStatus: %s",id,name,materials,cost,price,strStatus);
    }

    public String menuToString(){
        return String.format("%s - %d VND",name,price);
    }
}
