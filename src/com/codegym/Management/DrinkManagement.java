package com.codegym.Management;

import com.codegym.Services.DrinkServices;
import com.codegym.Unit.Drink;

import java.util.List;
import java.util.Scanner;

public class DrinkManagement {
    static final DrinkServices services = new DrinkServices();
    final Scanner scanner = new Scanner(System.in);

    public DrinkManagement() {
    }

    public void selectAllDrinkSelling() {
        List<Drink> drinks = services.selectAllDrinkSelling();
        for (Drink drink : drinks) {
            System.out.println(drink.toString());
        }
    }

    public void updateDrink() {
        selectAllDrinkSelling();
        List<Drink> drinks = services.selectAllDrinkSelling();
        if (drinks.isEmpty())
            System.out.println("List empty");
        else {
            System.out.println("Enter ID drink to update: ");
            try {
                int id = Integer.parseInt(scanner.nextLine());
                if (services.isExist(id)) {
                    System.out.println("Enter new name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter new materials:  ");
                    String materials = scanner.nextLine();
                    System.out.println("Enter cost to update: ");
                    long cost = Long.parseLong(scanner.nextLine());
                    System.out.println("Enter price to update: ");
                    System.out.printf("Suggest price about: %d - %d VND\n", cost + (cost * 30 / 100), cost + (cost * 40 / 100));
                    long price = Long.parseLong(scanner.nextLine());
                    if (services.updateDrink(id, name, materials, cost, price, 1))
                        System.out.println("Done");
                } else
                    System.out.println("ID not found");

            } catch (Exception e) {
                System.err.println("Error. Wrong data");
            }
        }
    }

    public void updateStatus() {
        selectAllDrinkSelling();
        List<Drink> drinks = services.selectAllDrinkSelling();
        if (drinks.isEmpty())
            System.out.println("List empty");
        else {
            System.out.println("Enter ID drink to remove: ");
            try {
                int id = Integer.parseInt(scanner.nextLine());
                if (services.isExist(id)) {
                    if (services.updateStatus(id))
                        System.out.println("Done");
                } else
                    System.out.println("ID not found");
            } catch (Exception e) {
                System.err.println("Error. Wrong data");
            }
        }
    }

    public void addDrink() {
        try {
            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            System.out.println("Enter materials: ");
            String materials = scanner.nextLine();
            System.out.println("Enter cost: ");
            long cost = Long.parseLong(scanner.nextLine());
            System.out.println("Enter price: ");
            System.out.printf("Suggest price about: %d - %d VND\n", cost + (cost * 30 / 100), cost + (cost * 40 / 100));
            long price = Long.parseLong(scanner.nextLine());
            services.addDrink(name, materials, cost, price, 1);
            System.out.println("Done");
        } catch (Exception e) {
            System.err.println("Error. Wrong data");
        }
    }

    public void findByName() {
        System.out.println("Enter name drink to search: ");
        String name = scanner.nextLine();
        List<Drink> drinks = services.findByName(name);
        if (drinks.isEmpty())
            System.out.println("Not found");
        else
            for (Drink drink : drinks) {
                System.out.println(drink.toString());
            }
    }

    public void sortByNameASC() {
        services.sortByNameASC();
    }

    public void sortByNameDESC() {
        services.sortByNameDESC();
    }

    public void sortByPriceASC() {
        services.sortByPriceASC();
    }

    public void sortByPriceDESC() {
        services.sortByPriceDESC();
    }

    public void selectAllDrink() {
        List<Drink> drinks = services.selectAllDrink();
        if (drinks.isEmpty())
            System.out.println("List empty");
        else {
            for (Drink drink : drinks) {
                System.out.println(drink.toString());
            }
        }
    }

    public void showMenu() {
        List<Drink> drinks= services.showMenu();
        System.out.println("############ MENU ############");
        System.out.println("Drinks                                    -                                    Price");
        for (Drink drink: drinks) {
            System.out.println(drink.menuToString());
        }
    }
}
