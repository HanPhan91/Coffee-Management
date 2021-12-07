package com.codegym.Services;
import com.codegym.Unit.OrderDetail;
import java.util.List;

public interface IOrderDetail {
    public List<OrderDetail> selectAllOrder();
    public void addOrderDetail(int idOrder, int idDrink, int quantity, long price, long total);
    public boolean isExist(int id);
    public OrderDetail getId(int id);
}
