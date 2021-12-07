package com.codegym.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConn {
    public static Connection getMySqlConnection(){
        String dbUrl = "jdbc:mysql://localhost:3306/coffee_manager";
        String userDb = "root";
        String passDb = "admin";
        return getMySqlConnection(dbUrl,userDb,passDb);
    }

    private static Connection getMySqlConnection(String dbUrl, String userDb, String passDb) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, userDb, passDb);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
