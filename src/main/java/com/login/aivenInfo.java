package com.login;

import com.manip.Licensee;

import javax.swing.table.DefaultTableModel;

public interface aivenInfo {
    boolean testAivenConnection();
    boolean validate(String username, String password);
    boolean newAccount(String username, String password);
    boolean loginAccount(String username, String password);
    void addNewDriver(Licensee driver);
    void deleteDriver(String licenseID);
    DefaultTableModel updateDatabase();
}