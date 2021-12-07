package com.codegym.Management;

import com.codegym.Services.OrderServices;
import com.codegym.Unit.Drink;
import com.codegym.Unit.Order;
import com.codegym.Unit.OrderDetail;
import com.codegym.Unit.Staff;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderManagement {
    final OrderServices services = new OrderServices();
    final DrinkManagement servicesDrink = new DrinkManagement();
    final StaffManagement servicesStaff = new StaffManagement();
    Scanner scanner = new Scanner(System.in);

    public void selectAllOrder() {
        List<Order> orders = services.selectAllOrder();
        if (orders.isEmpty())
            System.out.println("List empty");
        else {
            for (Order order : orders) {
                System.out.println(order.toString());
            }
        }
    }

    public boolean checkIdStaff(int id) {
        List<Staff> staffs = servicesStaff.services.selectAllStaffWorking();
        for (Staff staff : staffs) {
            if (staff.getId() == id)
                return true;
        }
        return false;
    }

    public boolean checkIdDrink(int id) {
        List<Drink> drinks = servicesDrink.services.selectAllDrinkSelling();
        for (Drink drink : drinks) {
            if (drink.getId() == id)
                return true;
        }
        return false;
    }

    public void addOrder() {
        boolean loop=true;
        boolean check = true;
        servicesStaff.showAllStaffWorking();
        long orderId = System.currentTimeMillis() / 1000;
        Date date = new Date();
        long total = 0;
        long total_amount = 0;
        List<Order> orders = new ArrayList<>();
        List<OrderDetail> details = new ArrayList<>();
        System.out.println("Input ID staff create order: ");
        try {
            int idStaff = Integer.parseInt(scanner.nextLine());
            if (checkIdStaff(idStaff)) {
                System.out.println("Enter number table: ");
                int table = Integer.parseInt(scanner.nextLine());
                do {
                    servicesDrink.showMenu();
                    System.out.println("Enter ID drink: ");
                    int idDrink = Integer.parseInt(scanner.nextLine());
                    if (checkIdDrink(idDrink)) {
                        long price = servicesDrink.services.getId(idDrink).getPrice();
                        System.out.println("Enter quantity: ");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        for (OrderDetail detail : details) {
                            if (detail.getIdDrink() == idDrink) {
                                quantity = detail.getQuantity() + quantity;
                                List<OrderDetail> remove = new ArrayList<>();
                                remove.add(detail);
                                details.removeAll(remove);
                                total = price * quantity;
                                total_amount += total;
                                details.add(new OrderDetail(orderId, idDrink, quantity, price, total));
                                check = true;
                                break;
                            }
                        }
                        if (check == false)
                            total = price * quantity;
                        total_amount += total;
                        details.add(new OrderDetail(orderId, idDrink, quantity, price, total));
                        System.out.println("Add new drink ? (1 to continue - 0 to end)");
                        int add = Integer.parseInt(scanner.nextLine());
                        if (add == 0)
                            loop= false;
                    } else
                        System.out.println("ID not found");
                } while (loop);
                if (services.addOrder(orderId, idStaff, table, date, total_amount, details))
                    System.out.println("Done");
            } else
                System.out.println("ID not found");

        } catch (Exception e) {
            System.err.println("Error. Wrong data");
        }
    }
}
