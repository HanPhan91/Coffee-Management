package com.codegym;

import com.codegym.Management.DrinkManagement;
import com.codegym.Management.OrderManagement;
import com.codegym.Management.StaffManagement;
import com.codegym.Management.UserManagement;
import com.codegym.Services.UserServices;

import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    final static UserManagement userManagement = new UserManagement();
    final static DrinkManagement drinkManagement = new DrinkManagement();
    final static StaffManagement staffManagement = new StaffManagement();

    public static void main(String[] args) {
        System.out.println("Coffee Management Login");
        System.out.println("Enter Username: ");
        String username = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        int check = userManagement.checkLogin(username, password);
        if (check == 1) {
            clearScreen();
            primaryMenu();
        } else if (check == 0)
            System.out.println("User login");
        else
            System.out.println("Username or Password not match");
    }

    public static void primaryMenu() {
        // write your code here
        do {
            System.out.println("----------------------------------------------------------");
            System.out.println("| 1. Staffs management                                   |");
            System.out.println("| 2. Drinks management                                   |");
            System.out.println("| 3. Orders management                                   |");
            System.out.println("| 4. User management                                     |");
            System.out.println("| 5. Exit                                                |");
            System.out.println("----------------------------------------------------------");
            System.out.println("Enter number category: ");
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number > 0 && number < 5) {
                    switch (number) {
                        case 1:
                            clearScreen();
                            staffManagement();
                            break;
                        case 2:
                            clearScreen();
                            drinkManagement();
                            break;
                        case 3:
                            clearScreen();
                            orderManagement();
                            break;
                        case 4:
                            clearScreen();
                            userManagement();
                            break;
                    }
                } else if (number == 4) {
                    System.out.println("Good bye");
                    break;
                } else
                    System.out.println("Please enter number 1 - 4");
            } catch (Exception e) {
                System.err.println("Error. Need enter number");
            }
        } while (true);
    }

    private static void userManagement() {
        do {
            System.out.println("-------------------------------------------User management");
            System.out.println("| 1. Show user active                                    |");
            System.out.println("| 2. Add new user                                        |");
            System.out.println("| 3. Change password                                     |");
            System.out.println("| 4. Remove user                                         |");
            System.out.println("| 5. Search by username                                  |");
            System.out.println("| 6. Show all user                                       |");
            System.out.println("| 7. Exit                                                |");
            System.out.println("----------------------------------------------------------");
            System.out.println("Enter number of category: ");
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number > 0 && number < 7) {
                    switch (number) {
                        case 1:
                            clearScreen();
                            userManagement.showUserActive();
                            break;
                        case 2:
                            clearScreen();
                            userManagement.addUser();
                            break;
                        case 3:
                            clearScreen();
                            userManagement.changePass();
                            break;
                        case 4:
                            clearScreen();
                            userManagement.removeUser();
                            break;
                        case 5:
                            clearScreen();
                            userManagement.searchByUser();
                            break;
                        case 6:
                            clearScreen();
                            userManagement.showAllUser();
                            break;
                    }
                } else if (number == 7) {
                    clearScreen();
                    break;
                } else
                    System.out.println("Please enter number 1 - 7");
            } catch (Exception e) {
                System.err.println("Error. Need enter number");
            }
        } while (true);
    }

    private static void orderManagement() {
//        OrderManagement orderManagement = new OrderManagement();
//        orderManagement.addOrder();
    }

    private static void drinkManagement() {

        do {
            System.out.println("-----------------------------------------Drinks management");
            System.out.println("| 1. Show Menu                                           |");
            System.out.println("| 2. Add new drink                                       |");
            System.out.println("| 3. Update drink                                        |");
            System.out.println("| 4. Remove drink                                        |");
            System.out.println("| 5. Search by name                                      |");
            System.out.println("| 6. Sort drink by name (A -> Z)                         |");
            System.out.println("| 7. Sort drink by name (Z -> A)                         |");
            System.out.println("| 8. Sort drink by price (ASC)                           |");
            System.out.println("| 9. Sort drink by price (DESC)                          |");
            System.out.println("| 10. Show all drink                                     |");
            System.out.println("| 11. Exit                                               |");
            System.out.println("----------------------------------------------------------");
            System.out.println("Enter number of category: ");
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number > 0 && number < 11) {
                    switch (number) {
                        case 1:
                            clearScreen();
                            drinkManagement.showMenu();
                            break;
                        case 2:
                            clearScreen();
                            drinkManagement.addDrink();
                            break;
                        case 3:
                            clearScreen();
                            drinkManagement.updateDrink();
                            break;
                        case 4:
                            clearScreen();
                            drinkManagement.updateStatus();
                            break;
                        case 5:
                            clearScreen();
                            drinkManagement.findByName();
                            break;
                        case 6:
                            clearScreen();
                            drinkManagement.sortByNameASC();
                            break;
                        case 7:
                            clearScreen();
                            drinkManagement.sortByNameDESC();
                            break;
                        case 8:
                            clearScreen();
                            drinkManagement.sortByPriceASC();
                            break;
                        case 9:
                            clearScreen();
                            drinkManagement.sortByPriceDESC();
                            break;
                        case 10:
                            clearScreen();
                            drinkManagement.selectAllDrink();
                            break;
                    }
                } else if (number == 11) {
                    clearScreen();
                    break;
                } else
                    System.out.println("Please enter number 1 - 11");
            } catch (Exception e) {
                System.err.println("Error. Need enter number");
            }
        } while (true);
    }

    private static void staffManagement() {

        do {
            System.out.println("------------------------------------------Staff management");
            System.out.println("| 1. Show all staff working                              |");
            System.out.println("| 2. Add new staff                                       |");
            System.out.println("| 3. Update staff                                        |");
            System.out.println("| 4. Remove staff                                        |");
            System.out.println("| 5. Search by name (All staff)                          |");
            System.out.println("| 6. Search by ID                                        |");
            System.out.println("| 7. Sort staff by name (A -> Z)                         |");
            System.out.println("| 8. Sort staff by name (Z -> A)                         |");
            System.out.println("| 9. Sort staff by ID (ASC)                              |");
            System.out.println("| 10. Sort staff by ID (DESC)                            |");
            System.out.println("| 11. Show all staff                                     |");
            System.out.println("| 12. Exit                                               |");
            System.out.println("----------------------------------------------------------");
            System.out.println("Enter number of category: ");
            try {
                int numberNV = Integer.parseInt(scanner.next());
                if (numberNV > 0 && numberNV < 12) {
                    switch (numberNV) {
                        case 1:
                            clearScreen();
                            staffManagement.showAllStaffWorking();
                            break;
                        case 2:
                            clearScreen();
                            staffManagement.addStaff();
                            break;
                        case 3:
                            clearScreen();
                            staffManagement.updateStaff();
                            break;
                        case 4:
                            clearScreen();
                            staffManagement.updateStatus();
                            break;
                        case 5:
                            clearScreen();
                            staffManagement.findByName();
                            break;
                        case 6:
                            clearScreen();
                            staffManagement.findById();
                            break;
                        case 7:
                            clearScreen();
                            staffManagement.sortByNameASC();
                            break;
                        case 8:
                            clearScreen();
                            staffManagement.sortByNameDESC();
                            break;
                        case 9:
                            clearScreen();
                            staffManagement.sortByIdASC();
                            break;
                        case 10:
                            clearScreen();
                            staffManagement.sortByIdDESC();
                            break;
                        case 11:
                            clearScreen();
                            staffManagement.showAllStaff();
                            break;
                    }
                } else if (numberNV == 12) {
                    clearScreen();
                    break;
                } else
                    System.out.println("Please enter number 1 - 12");
            } catch (Exception e) {
                System.err.println("Error. Need enter number");
            }
        } while (true);
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
