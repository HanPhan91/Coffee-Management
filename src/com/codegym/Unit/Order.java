package com.codegym.Unit;

import java.time.LocalDateTime;
import java.util.Date;

public class Order {
    private long id;
    private int table;
    private int idstaff;
    private long total_amount;
    private Date date;
    public Order() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Order(long id, int idstaff, int table,  Date date , long total_amount) {
        this.table = table;
        this.idstaff = idstaff;
        this.date=date;
        this.total_amount = total_amount;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public int getIdstaff() {
        return idstaff;
    }

    public void setIdstaff(int idstaff) {
        this.idstaff = idstaff;
    }

    public long getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(long total_amount) {
        this.total_amount = total_amount;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nCreate by ID staff: %d\nTable: %d\nTotal amount: %d",id,idstaff,table,total_amount);
    }
}
