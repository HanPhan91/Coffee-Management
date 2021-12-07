package com.codegym.Unit;

public class OrderDetail {
    private long idOrder;
    private int idDrink;
    private int quantity;
    private long price;
    private long total;

    public OrderDetail() {
    }

    public OrderDetail(long idOrder, int idDrink, int quantity, long price, long total) {
        this.idOrder = idOrder;
        this.idDrink = idDrink;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(int idDrink) {
        this.idDrink = idDrink;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

}
