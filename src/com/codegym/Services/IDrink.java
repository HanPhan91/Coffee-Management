package com.codegym.Services;
import com.codegym.Unit.Drink;
import java.util.List;
public interface IDrink {
    public List<Drink> selectAllDrinkSelling();
    public boolean updateDrink(int id, String name, String materials,double cost, double price, int status);
    public boolean updateStatus(int id);
    public void addDrink(String name, String materials, double cost, double price, int status);
    public boolean isExist(int id);
    public Drink getId(int id);
    public List<Drink> findByName(String name);
    public void sortByNameASC();
    public void sortByNameDESC();
    public void sortByPriceASC();
    public void sortByPriceDESC();
    public List<Drink> selectAllDrink();
    public List<Drink> showMenu();
}
