package com.codegym.Unit;

public class User {
    private String username;
    private String password;
    private int roles;
    private int idStaff;
    private int status;


    public User() {
    }

    public User(String username, String password, int roles, int idStaff, int status) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.idStaff = idStaff;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRoles() {
        return roles;
    }

    public void setRoles(int roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    @Override
    public String toString() {
        String strRoles = null;
        String strStatus= null;
        if (this.roles == 1)
            strRoles = "admin";
        else
            strRoles = "user";
        if (this.status == 1)
            strStatus= "active";
        else
            strStatus= "deactive";
        return String.format("ID: %s | Password: %s | Roles: %s | ID Staff: %d | Status: %s", username, password, strRoles, idStaff, strStatus);
    }
}
