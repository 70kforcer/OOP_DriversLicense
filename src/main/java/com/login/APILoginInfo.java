package com.login;

import javax.swing.*;
import java.sql.*;

public class APILoginInfo extends aivenLogin {
    private String username = System.getProperty("databaseUSERNAME");
    private String password = System.getProperty("databasePASSWORD");
    private String URL = "jdbc:mysql://" + System.getProperty("databaseURL");

    public void setUsername(String _username) {
        this.username = _username;
    }
    public String getUsername() {
        return username;
    }

    public void setPassword(String _password) {
        this.password = _password;
    }
    public String getPassword() {
        return password;
    }

    public void setURL(String _URL) {
        this.URL = _URL;
    }
    public String getURL() {
        return URL;
    }

    @Override
    public boolean testAivenConnection() {
        try {
            Connection testConnection = DriverManager.getConnection(
                    this.getURL(),
                    this.getUsername(),
                    this.getPassword()
            );

            if (testConnection != null) {
                System.out.println(this.getUsername() + " has connected to the database.");
                return true;
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println("No such account.");
            return false;
        }
    }

    @Override
    public boolean validate(String username1, String password1) {
        try {
            Connection loginConnection = DriverManager.getConnection(
                    this.getURL() + "/login_schema",
                    this.getUsername(),
                    this.getPassword()
            );
            PreparedStatement loginStatement = loginConnection.prepareStatement(
                    "SELECT * FROM login_schema.users1 WHERE username = ?");
            loginStatement.setString(1, username1);
            ResultSet usernameResultSet = loginStatement.executeQuery();
            if (usernameResultSet.next()) {
                String dbPassword = usernameResultSet.getString("password");
                return dbPassword.equals(password1);
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean newAccount(String newUsername, String newPassword) {
        try {
            Connection registerConnection = DriverManager.getConnection(
                    this.getURL() + "/login_schema",
                    this.getUsername(),
                    this.getPassword()
            );

            // checks if username exists already
            boolean isExisting = false;
            PreparedStatement checkUsernameStatement = registerConnection.prepareStatement(
                    "SELECT COUNT(*) FROM login_schema.users1 WHERE username = ?"
            );
            checkUsernameStatement.setString(1, newUsername);
            ResultSet usernameResultSet = checkUsernameStatement.executeQuery();
            if (usernameResultSet.next()) {
                int count = usernameResultSet.getInt(1);
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Username already exists.");
                    isExisting = true;
                }
            }

            if (!isExisting) {
                PreparedStatement registerStatement = registerConnection.prepareStatement(
                        "INSERT INTO login_schema.users1 (username, password) VALUES (?, ?)"
                );
                registerStatement.setString(1, newUsername);
                registerStatement.setString(2, newPassword);
                registerStatement.executeUpdate();
                return true;
            }
            return false;
        } catch (SQLException se) {
            System.out.println("Error while creating a new account:");
            return false;
        }
    }
}