package com.codegym.Management;

import com.codegym.Services.StaffServices;
import com.codegym.Unit.Staff;
import com.codegym.regex.PhoneNumberInvalid;

import java.util.List;
import java.util.Scanner;

public class StaffManagement {
    final StaffServices services = new StaffServices();
    Scanner scanner = new Scanner(System.in);
    final PhoneNumberInvalid regex = new PhoneNumberInvalid();

    public StaffManagement() {
    }

    public void showAllStaffWorking() {
        List<Staff> staffs = services.selectAllStaffWorking();
        for (Staff staff : staffs) {
            System.out.println(staff.toString());
        }
    }

    public void addStaff() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("-------------------------New staff:");
        System.out.println("1. Manager                        |");
        System.out.println("2. Cashier                        |");
        System.out.println("3. Barista                        |");
        System.out.println("4. Staff                          |");
        System.out.println("Enter any key to exit             |");
        System.out.println("-----------------------------------");
        System.out.println("Enter position of staff: ");
        try {
            int number = Integer.parseInt(scanner.nextLine());
            if (number > 0 && number < 5) {
                String position = null;
                switch (number) {
                    case (1):
                        position = "Manager";
                        break;
                    case (2):
                        position = "Cashier";
                        break;
                    case (3):
                        position = "Barista";
                        break;
                    case (4):
                        position = "Staff";
                        break;
                }
                System.out.println("Enter address of staff: ");
                String address = scanner.nextLine();
                System.out.println("Enter phone number of staff: ");
                String phone = scanner.nextLine();
                if (regex.validate(phone)) {
                    services.addStaff(name, position, address, phone, 1);
                    System.out.println("Done");
                } else
                    System.out.println("Phone number invalid");
            } else
                System.out.println("Please enter number 1-4");
        } catch (Exception e) {
            System.err.println("Error. Wrong data");
        }
    }

    public void updateStaff() {
        showAllStaffWorking();
        List<Staff> staffs = services.selectAllStaffWorking();
        if (staffs.isEmpty())
            System.out.println("List empty");
        else {
            System.out.println("Enter ID staff to update: ");
            try {
                int id = Integer.parseInt(scanner.nextLine());
                if (services.isExist(id)) {
                    System.out.println("Enter new name: ");
                    String name = scanner.nextLine();
                    System.out.println("------------------------New staff: ");
                    System.out.println("1. Management                     |");
                    System.out.println("2. Cashier                        |");
                    System.out.println("3. Barista                        |");
                    System.out.println("4. Staff                          |");
                    System.out.println("Any key to exit                   |");
                    System.out.println("-----------------------------------");
                    System.out.println("Enter new position: ");
                    int number = Integer.parseInt(scanner.nextLine());
                    if (number > 0 && number < 5) {
                        String position = null;
                        switch (number) {
                            case (1):
                                position = "Manager";
                                break;
                            case (2):
                                position = "Cashier";
                                break;
                            case (3):
                                position = "Barista";
                                break;
                            case (4):
                                position = "Staff";
                                break;
                        }
                        System.out.println("Enter new address: ");
                        String address = scanner.nextLine();
                        System.out.println("Enter new phone number: ");
                        String phone = scanner.nextLine();
                        if (regex.validate(phone))
                            if (services.updateStaff(id, name, position, address, phone, 1))
                                System.out.println("Done");
                            else
                                System.out.println("Phone number invalid");
                    } else
                        System.out.println("Please enter number 1-4");
                } else
                    System.out.println("ID not found");
            } catch (Exception e) {
                System.err.println("Error. Wrong data");
            }
        }
    }

    public void updateStatus() {
        showAllStaffWorking();
        List<Staff> staffs = services.selectAllStaffWorking();
        if (staffs.isEmpty())
            System.out.println("List empty");
        else {
            System.out.println("Enter ID staff to update: ");
            try {
                int id = Integer.parseInt(scanner.nextLine());
                if (services.isExist(id)) {
                    if (services.updateStatus(id))
                        System.out.println("Done");
                } else
                    System.out.println("ID not found");

            } catch (Exception e) {
                System.err.println("Error.Wrong data");
            }
        }
    }

    public void findById() {
        System.out.println("Enter ID to search: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Staff staff = services.getId(id);
            if (staff == null)
                System.out.println("ID not found");
            else
                System.out.println(staff.toString());
        } catch (Exception e) {
            System.err.println("Error. Wrong data");
        }
    }

    public void findByName() {
        System.out.println("Enter name to search: ");
        String name = scanner.nextLine();
        List<Staff> listStaff = services.findByName(name);
        if (listStaff.isEmpty()) {
            System.out.println("Not found");
        } else {
            for (Staff staff : listStaff) {
                System.out.println(staff.toString());
            }
        }
    }

    public void sortByNameASC() {
        services.sortByNameASC();
    }

    public void sortByNameDESC() {
        services.sortByNameDESC();
    }

    public void sortByIdASC() {
        services.sortByIdASC();
    }

    public void sortByIdDESC() {
        services.sortByIdDESC();
    }

    public void showAllStaff() {
        List<Staff> staffs = services.selectAllStaff();
        for (Staff staff : staffs) {
            System.out.println(staff.toString());
        }
    }
}
