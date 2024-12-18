package com.login;

import com.manip.Licensee;

import javax.swing.table.DefaultTableModel;

public abstract class aivenLogin implements aivenInfo {
    public abstract boolean testAivenConnection();
    public abstract boolean validate(String username, String password);
    public abstract boolean newAccount(String username, String password);
    public abstract boolean loginAccount(String username, String password);
    public abstract void addNewDriver(Licensee driver);
    public abstract void deleteDriver(String licenseID);
    public abstract DefaultTableModel updateDatabase();
}