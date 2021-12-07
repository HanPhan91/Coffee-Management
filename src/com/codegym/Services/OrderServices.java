package com.codegym.Services;

import com.codegym.Unit.Order;
import com.codegym.Unit.OrderDetail;
import com.codegym.connector.MySqlConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderServices implements IOrder{
    private final Connection connection= MySqlConn.getMySqlConnection();
    private final String SELECTALL = "select * from order";
    private final String ADDORDER = "insert into order(id,idstaff,table,date,total_amount) VALUES(?,?,?,?,?);";
    private final String ADDORDER_DETAIL= "insert into order_detail(idorder,iddrink,quantity,price,total) VALUES(?,?,?,?,?);";
    private final String SELECT_ORDERDETAIL_BY_IDORDER= "select * from order_detail where idorder=?";
    private final StaffServices staffServices= new StaffServices();
    private final DrinkServices drinkServices= new DrinkServices();
    @Override
    public List<Order> selectAllOrder() {
        List<Order> orders= new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTALL);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=  resultSet.getInt("id");
                int idstaff= resultSet.getInt("idstaff");
                int table= resultSet.getInt("table");
                Date date= resultSet.getDate("date");
                long total= resultSet.getLong("total_amount");
                orders.add(new Order(id,idstaff,table,date,total));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean addOrder(long idOrder,int idStaff, int table, Date date, long total_amount, List<OrderDetail> lists) {
        boolean check=true;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(ADDORDER);
            preparedStatement.setLong(1,idStaff);
            preparedStatement.setInt(2,idStaff);
            preparedStatement.setInt(3,table);
            preparedStatement.setDate(4, (java.sql.Date) date);
            preparedStatement.setLong(5,total_amount);
            preparedStatement.executeUpdate();
            for (OrderDetail detail: lists) {
                PreparedStatement preparedStatement2= connection.prepareStatement(ADDORDER_DETAIL);
                preparedStatement2.setLong(1,idOrder);
                preparedStatement2.setInt(2, detail.getIdDrink());
                preparedStatement2.setInt(3,detail.getQuantity());
                preparedStatement2.setLong(4,detail.getPrice());
                preparedStatement2.setLong(5,detail.getTotal());
                preparedStatement2.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean isExist(int id) {
        return false;
    }

    @Override
    public Order getId(int id) {
        return null;
    }

    @Override
    public void sortByDate() {

    }

    @Override
    public void sortByTotalAmountASC() {

    }

    @Override
    public void sortByTotalAmountDESC() {

    }
}
