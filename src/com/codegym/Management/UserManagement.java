package com.codegym.Management;

import com.codegym.Services.StaffServices;
import com.codegym.Services.UserServices;
import com.codegym.Unit.Staff;
import com.codegym.Unit.User;

import java.util.List;
import java.util.Scanner;

public class UserManagement {
    final UserServices services = new UserServices();
    final Scanner scanner = new Scanner(System.in);

    public int checkLogin(String username, String password) {
        List<User> lists = services.showUserActive();
        for (User user : lists) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return user.getRoles();
        }
        return -1;
    }

    public void showUserActive() {
        List<User> lists = services.showUserActive();
        for (User user : lists) {
            System.out.println(user.toString());
        }
    }

    public void showAllUser() {
        List<User> lists = services.showAllUser();
        for (User user : lists) {
            System.out.println(user.toString());
        }
    }

    public void addUser() {
        StaffServices staffServices = new StaffServices();
        List<Staff> staffs = staffServices.selectAllStaff();
        if (staffs.isEmpty())
            System.out.println("List empty");
        else {
            for (Staff staff : staffs) {
                System.out.println(staff.toString());
            }
            System.out.println("Enter id staff: ");
            try {
                int idStaff = Integer.parseInt(scanner.nextLine());
                if (staffServices.isExist(idStaff)) {
                    System.out.println("Enter username: ");
                    String user = scanner.nextLine();
                    if (!services.isExist(user)) {
                        System.out.println("Enter password: ");
                        String pass = scanner.nextLine();
                        System.out.println("Enter number 1 to set Role = admin | else number for Role = user");
                        int roles = Integer.parseInt(scanner.nextLine());
                        if (roles == 1) {
                            if (services.addUser(user, pass, 1, idStaff, 1))
                                System.out.println("Done");
                        } else {
                            if (services.addUser(user, pass, 0, idStaff, 1))
                                System.out.println("Done");
                        }
                    } else
                        System.out.println("Error. Username is exist");
                } else
                    System.out.println("ID not found");

            } catch (Exception e) {
                System.err.println("Error.Wrong data");
            }
        }
    }

    public void changePass() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        User user = services.getUser(username);
        if (user == null)
            System.out.println("Username not found");
        else {
            System.out.println("Enter new password: ");
            String pass1 = scanner.nextLine();
            System.out.println("Enter new password again: ");
            String pass2 = scanner.nextLine();
            if (pass1.equals(pass2)) {
                if (services.changePass(username, pass1))
                    System.out.println("Done");
            } else
                System.out.println("Password not match");
        }
    }

    public void removeUser() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        User user = services.getUser(username);
        if (user != null) {
            if (services.updateStatus(username))
                System.out.println("Done");
        } else System.out.println("Username not found");
    }
}
