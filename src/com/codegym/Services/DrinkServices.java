package com.codegym.Services;

import com.codegym.Unit.Drink;

import com.codegym.connector.MySqlConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DrinkServices implements IDrink {
    private static final String SELECTALL = "select * from drink";
    private static final String ADDSTAFF = "insert into drink(name,materials,cost,price,status) VALUES(?,?,?,?,?);";
    private static final String UPDATESTATUS = "update drink set status=? where id=?";
    private static final String UPDATESTAFF = "update drink set name=?,materials=?,cost=?,price=?,status=? where id=?;";
    private static final String FINDBYNAME = "select * from drink WHERE name IN (?);";
    private static final String SELECTWORKING = "select * from drink where status = 1";
    private static final Connection connection= MySqlConn.getMySqlConnection();

    public DrinkServices() {
    }

    @Override
    public List<Drink> selectAllDrinkSelling() {
        List<Drink> drinks= new ArrayList<>();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECTWORKING);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String materials = resultSet.getString("materials");
                long cost = resultSet.getLong("cost");
                long price = resultSet.getLong("price");
                int status = resultSet.getInt("status");
                if (status == 1)
                    drinks.add(new Drink(id, name, materials, cost, price, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drinks;
    }

    @Override
    public boolean updateDrink(int id, String name, String materials, double cost, double price, int status) {
        boolean check = false;
        try {
//            Connection connection= MySqlConn.getMySqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATESTAFF);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, materials);
            preparedStatement.setDouble(3, cost);
            preparedStatement.setDouble(4, price);
            preparedStatement.setInt(5, status);
            preparedStatement.setInt(6, id);
            check = preparedStatement.executeUpdate() > 0;
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean updateStatus(int id) {
        boolean check = false;
        try {
//            Connection connection= MySqlConn.getMySqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATESTATUS);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public void addDrink(String name, String materials, double cost, double price, int status) {
        try {
//            Connection connection= MySqlConn.getMySqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADDSTAFF);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, materials);
            preparedStatement.setDouble(3, cost);
            preparedStatement.setDouble(4, price);
            preparedStatement.setInt(5, status);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean isExist(int id) {
        return getId(id) != null;
    }

    @Override
    public Drink getId(int id) {
        List<Drink> drinks = selectAllDrinkSelling();
        for (Drink drink: drinks) {
            if (drink.getId() == id)
                return drink;
        }
        return null;
    }

    @Override
    public List<Drink> findByName(String name) {
        List<Drink> drinks = selectAllDrinkSelling();
        List<Drink> results = new ArrayList<>();
        for (Drink drink : drinks) {
            if (drink.getName().contains(name))
                results.add(drink);
        }
        return results;
    }

    @Override
    public void sortByNameASC() {
        List<Drink> drinks = selectAllDrinkSelling();
        drinks.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        for (Drink drink : drinks) {
            System.out.println(drink.toString());
        }
    }

    @Override
    public void sortByNameDESC() {
        List<Drink> drinks = selectAllDrinkSelling();
        drinks.sort((o1, o2) -> o2.getName().compareTo(o1.getName()));
        for (Drink drink : drinks) {
            System.out.println(drink.toString());
        }
    }

    @Override
    public void sortByPriceASC() {
        List<Drink> drinks = selectAllDrinkSelling();
        Collections.sort(drinks, new Comparator<Drink>() {
            @Override
            public int compare(Drink o1, Drink o2) {
                return o1.getPrice() > o2.getPrice() ? 1 : -1;
            }
        });
        for (Drink drink : drinks) {
            System.out.println(drink.toString());
        }
    }

    @Override
    public void sortByPriceDESC() {
        List<Drink> drinks = selectAllDrinkSelling();
        Collections.sort(drinks, new Comparator<Drink>() {
            @Override
            public int compare(Drink o1, Drink o2) {
                return o1.getPrice() > o2.getPrice() ? -1 : 1;
            }
        });
        for (Drink drink : drinks) {
            System.out.println(drink.toString());
        }
    }


    @Override
    public List<Drink> selectAllDrink() {
        List<Drink> drinks = new ArrayList<>();
        try {
//            Connection connection= MySqlConn.getMySqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String materials = resultSet.getString("materials");
                long cost = resultSet.getLong("cost");
                long price = resultSet.getLong("price");
                int status = resultSet.getInt("status");
                drinks.add(new Drink(id, name, materials, cost, price, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drinks;
    }

    @Override
    public List<Drink> showMenu() {
        List<Drink> drinks= selectAllDrinkSelling();
        return drinks;
    }
}
