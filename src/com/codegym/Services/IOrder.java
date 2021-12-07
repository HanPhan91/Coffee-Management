package com.codegym.Services;

import com.codegym.Unit.Order;
import com.codegym.Unit.OrderDetail;

import java.util.Date;
import java.util.List;

public interface IOrder {
    public List<Order> selectAllOrder();
    public boolean addOrder(long idOrder,int idStaff, int table, Date date, long total_amount, List<OrderDetail>lists);
    public boolean isExist(int id);
    public Order getId(int id);
    public void sortByDate();
    public void sortByTotalAmountASC();
    public void sortByTotalAmountDESC();
}
