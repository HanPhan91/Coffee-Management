package com.codegym.DAO;

import com.codegym.Unit.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO implements IStaff {
    private final String dbUrl = "jdbc:mysql://localhost:3306/coffee_manager";
    private final String userDb = "root";
    private final String passDb = "admin";

    private static final String SELECTALL = "select * from staff";
    private static final String ADDSTAFF = "insert into staff(name,position,address,phone,active) VALUES(?,?,?,?,?);";
    private static final String UPDATESTATUS = "update staff set active=? where id=?";
    private static final String UPDATESTAFF = "update staff set name=?, position=?,address=?,phone=?, status=? where id=?;";
    private static final String FINDBYNAME = "select * from staff WHERE name IN (?);";
    private static final String SELECTWORKING = "select * from staff where active = 1";

    public StaffDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, userDb, passDb);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Staff> selectAllStaffWorking() {
        List<Staff> staffs = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTWORKING);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                int status = resultSet.getInt("status");
                if (status == 1)
                    staffs.add(new Staff(id, name, position, address, phone, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffs;
    }

    @Override
    public boolean updateStaff(int id, String name, String position, String address, String phone, int status) {
        boolean check = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATESTAFF);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, position);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, phone);
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
            Connection connection = getConnection();
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
    public void addStaff(String name, String position, String address, String phone, int status) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADDSTAFF);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, position);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, phone);
            preparedStatement.setInt(5, status);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean isExist(int id) {
        return getId(id) != null;
    }

    @Override
    public Staff getId(int id) {
        List<Staff> staffs = selectAllStaffWorking();
        for (Staff staff : staffs) {
            if (staff.getId() == id)
                return staff;
        }
        return null;
    }

    @Override
    public List<Staff> findByName(String name) {
        List<Staff> staffs = selectAllStaffWorking();
        List<Staff> results = new ArrayList<>();
        for (Staff staff : staffs) {
            if (staff.getName().equalsIgnoreCase(name))
                results.add(staff);
        }
        return results;
    }

    @Override
    public void sortByNameASC() {
        List<Staff> staffs = selectAllStaff();
        staffs.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        for (Staff staff : staffs) {
            System.out.println(staff.toString());
        }
    }

    @Override
    public void sortByNameDESC() {
        List<Staff> staffs = selectAllStaff();
        staffs.sort((o1, o2) -> o2.getName().compareTo(o1.getName()));
        for (Staff staff : staffs) {
            System.out.println(staff.toString());
        }
    }

    @Override
    public void sortByIdASC() {
        List<Staff> staffs = selectAllStaff();
        staffs.sort((o1, o2) -> o1.getId() - o2.getId());
        for (Staff staff : staffs) {
            System.out.println(staff.toString());
        }
    }

    @Override
    public void sortByIdDESC() {
        List<Staff> staffs = selectAllStaff();
        staffs.sort((o1, o2) -> o2.getId() - o1.getId());
        for (Staff staff : staffs) {
            System.out.println(staff.toString());
        }
    }

    @Override
    public List<Staff> selectAllStaff() {
        List<Staff> staffs = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTWORKING);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                int status = resultSet.getInt("status");
                staffs.add(new Staff(id, name, position, address, phone, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffs;
    }
}
