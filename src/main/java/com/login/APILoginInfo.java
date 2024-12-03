package com.login;

import java.sql.*;

public class APILoginInfo extends aivenLogin {
    private String username;
    private String password;
    private String URL;

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
            System.out.println("URL: " + this.getURL());
            System.out.println("Username: " + this.getUsername());
            System.out.println("Password: " + this.getPassword());

            Connection testConnection = DriverManager.getConnection(
                    "jdbc:mysql://" + this.getURL() + "/login_schema",
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
}