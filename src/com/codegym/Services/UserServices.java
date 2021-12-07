package com.codegym.Services;

import com.codegym.Unit.User;
import com.codegym.connector.MySqlConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServices implements IUser{
    private static final String SELECTALL = "select * from user";
    private static final String ADDUSER = "insert into user(username,password,role,idstaff,status) VALUES(?,?,?,?,?);";
    private static final String UPDATESTATUS = "update user set status=0 where username=?";
    private static final String CHANGEPASS = "update user set password=? where username=?;";
    private static final String SELECTACTIVE = "select * from user where status = 1";
    private static final Connection connection= MySqlConn.getMySqlConnection();

    @Override
    public List<User> showUserActive() {
        List<User> lists= new ArrayList<>();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECTACTIVE);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                String user= resultSet.getString("username");
                String pass= resultSet.getString("password");
                int roles= resultSet.getInt("role");
                int idStaff= resultSet.getInt("idstaff");
                int status= resultSet.getInt("status");
                lists.add(new User(user,pass,roles,idStaff,status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }

    @Override
    public List<User> showAllUser() {
        List<User> lists= new ArrayList<>();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECTALL);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                String user= resultSet.getString("username");
                String pass= resultSet.getString("password");
                int roles= resultSet.getInt("role");
                int idStaff= resultSet.getInt("idstaff");
                int status= resultSet.getInt("status");
                lists.add(new User(user,pass,roles,idStaff,status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }

    @Override
    public boolean addUser(String user, String pass, int roles, int idStaff, int status) {
        boolean check = false;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(ADDUSER);
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,pass);
            preparedStatement.setInt(3,roles);
            preparedStatement.setInt(4,idStaff);
            preparedStatement.setInt(5,status);
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean changePass(String user,String pass) {
        boolean check= false;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(CHANGEPASS);
            preparedStatement.setString(1,pass);
            preparedStatement.setString(2,user);
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean updateStatus(String user) {
        boolean check= false;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(UPDATESTATUS);
            preparedStatement.setString(1,user);
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public User getUser(String username) {
        List<User> lists = showUserActive();
        for (User user:lists ) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    @Override
    public boolean isExist(String user) {
        return getUser(user) != null;
    }
}
