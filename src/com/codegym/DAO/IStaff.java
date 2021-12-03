package com.codegym.DAO;
import com.codegym.Unit.Staff;
import java.util.List;
public interface IStaff {
    public List<Staff> selectAllStaffWorking();
    public boolean updateStaff(int id, String name, String position,String address, String phone, int status);
    public boolean updateStatus(int id);
    public void addStaff(String name, String position, String address, String phone, int status);
    public boolean isExist(int id);
    public Staff getId(int id);
    public List<Staff> findByName(String name);
    public void sortByNameASC();
    public void sortByNameDESC();
    public void sortByIdASC();
    public void sortByIdDESC();
    public List<Staff> selectAllStaff();
}
