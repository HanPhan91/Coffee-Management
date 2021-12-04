package com.codegym;

import com.codegym.services.StaffManagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("----------------------------------------------------------");
            System.out.println("| 1. Staffs management                                   |");
            System.out.println("| 2. Drinks management                                   |");
            System.out.println("| 3. Orders management                                   |");
            System.out.println("| 4. Exit                                                |");
            System.out.println("----------------------------------------------------------");
            System.out.println("Enter number category: ");
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number > 0 && number < 4) {
                    switch (number) {
                        case 1:
                            clearScreen();
                            staffManagement();
                            break;
                        case 2:
                            clearScreen();
//                            drinkManagement();
                            break;
                        case 3:
                            clearScreen();
//                            orderManagement();
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

    private static void staffManagement() {
        StaffManagement staffManagement = new StaffManagement();
        Scanner scanner = new Scanner(System.in);
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
                    System.out.println("Please enter number 1 - 10");
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
