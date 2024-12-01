package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class APILoginInfo extends aivenLogin {
    private String username;
    private String password;

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

    @Override
    public boolean testAivenConnection() {
        try {
            Connection testConnection = DriverManager.getConnection(
                    "jdbc:mysql://" +
                            "oopgovsystem01-govsystem01.e.aivencloud.com:16924/login_schema",
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