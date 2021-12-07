package com.codegym.Services;

import com.codegym.Unit.User;

import java.util.List;

public interface IUser {
    public List<User> showUserActive();
    public List<User> showAllUser();
    public boolean addUser(String user, String pass, int roles, int idStaff, int status);
    public boolean changePass(String user,String pass);
    public boolean updateStatus(String user);
    public User getUser(String user);
    public boolean isExist(String user);

}
