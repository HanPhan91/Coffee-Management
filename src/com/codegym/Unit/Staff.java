package com.codegym.Unit;

public class Staff {
    private int id;
    private String name;
    private String position;
    private String address;
    private String phone;
    private int status;

    public Staff(int id, String name, String materials, double cost, double price, int status) {
    }

    public Staff(int id, String name, String position, String address, String phone, int status) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.address = address;
        this.phone = phone;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
            strStatus = "Working";
        else
            strStatus= "Quit";
        return String.format("ID: %d\nName: %s\nPosition: %s\nAddress: %s\nPhone number: %s\nStatus: %s",id,name,position,address,phone,strStatus);
    }
}
