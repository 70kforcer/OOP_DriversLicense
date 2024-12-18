package com.login;

import com.manip.Licensee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Vector;

public class APILoginInfo extends aivenLogin {

    private String username;
    private String password;
    private String URL;

    public APILoginInfo() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                System.out.println("Cannot find database.properties file.");
                return;
            }
            properties.load(input);
            this.username = properties.getProperty("databaseUSERNAME");
            this.password = properties.getProperty("databasePASSWORD");
            this.URL = "jdbc:mysql://" + properties.getProperty("databaseURL");
        } catch (IOException ioe) {
            System.out.println("Error while reading database.properties file.");
        }
    }

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

    //LoginForm method for CheckAPI button
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
            System.out.println("Cannot connect to database. Try again later.");
            return false;
        }
    }

    //checks if there is a proper connection with Aiven Cloud
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

    //adds new users for database interaction
    @Override
    public boolean newAccount(String newUsername, String newPassword) {
        try {
            Connection registerConnection = DriverManager.getConnection(
                    this.getURL() + "/login_schema",
                    this.getUsername(),
                    this.getPassword()
            );

            //checks if username exists already
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

            //if username is available, registers username and corresponding password
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
            JOptionPane.showMessageDialog(null,
                    "An error occurred while creating account.\nPlease try again.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error while creating a new account.");
            return false;
        }
    }

    //verifies if username & password match and is in the login schema
    @Override
    public boolean loginAccount(String username, String newPassword) {
        try {
            Connection loginConnection = DriverManager.getConnection(
                    this.getURL() + "/login_schema",
                    this.getUsername(),
                    this.getPassword()
            );
            PreparedStatement loginStatement = loginConnection.prepareStatement(
                    "SELECT password FROM login_schema.users1 WHERE username = ?"
            );
            loginStatement.setString(1, username);
            ResultSet resultSet = loginStatement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                if (dbPassword.equals(newPassword)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred during login: " + e.getMessage());
        }

        return false;
    }

    //adds new licensees
    @Override
    public void addNewDriver (Licensee licensee) {
        try {
            Connection newLicenseeConnection = DriverManager.getConnection(
                    this.getURL() + "/user_database",
                    this.getUsername(),
                    this.getPassword()
            );

            PreparedStatement newLicenseeStatement = newLicenseeConnection.prepareStatement(
                    "INSERT INTO user_database.licensees " +
                            "(LastName, FirstName, MiddleName, Sex, DateOfBirth, " +
                            "Weight, Height, Address, CreationDate, ExpirationDate, Restrictions) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, curdate(), date_add(curdate(), interval 5 year), (?))"
            );

            newLicenseeStatement.setString(1, licensee.getLicenseeLN());
            newLicenseeStatement.setString(2, licensee.getLicenseeFN());
            newLicenseeStatement.setString(3, licensee.getLicenseeMN());

            newLicenseeStatement.setString(4, licensee.getLicenseeSex());
            newLicenseeStatement.setString(5, licensee.getLicenseeDOB());
            newLicenseeStatement.setString(6, licensee.getLicenseeWT());
            newLicenseeStatement.setString(7, licensee.getLicenseeHT());

            newLicenseeStatement.setString(8, licensee.getLicenseeADD());

            //debugging
            System.out.println("Licensee Details:");
            System.out.println("Last Name: " + licensee.getLicenseeLN());
            System.out.println("First Name: " + licensee.getLicenseeFN());
            System.out.println("Middle Name: " + licensee.getLicenseeMN());
            System.out.println("Sex: " + licensee.getLicenseeSex());
            System.out.println("Date of Birth: " + licensee.getLicenseeDOB());
            System.out.println("Weight: " + licensee.getLicenseeWT());
            System.out.println("Height: " + licensee.getLicenseeHT());
            System.out.println("Address: " + licensee.getLicenseeADD());
            System.out.println("Restrictions: " + licensee.formatRST());

            newLicenseeStatement.setString(9, licensee.formatRST());

            int rowsAffected = newLicenseeStatement.executeUpdate();

            //checks if the update went through
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null,
                        "New licensee has been added to the database.",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("New licensee has been added to the database.");
            } else {
                JOptionPane.showMessageDialog(null,
                        "No rows were affected. No licensee was added.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("No licensee was added to the database.");
            }
        } catch (SQLException se) {
            se.getStackTrace();
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding new licensee to database.\nPlease try again.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error while adding new licensee to database.");
        }
    }

    //deletes licensees based on ID input
    @Override
    public void deleteDriver (String licenseID) {
        try {
            Connection deleteConnection = DriverManager.getConnection(
                    this.getURL() + "/user_database",
                    this.getUsername(),
                    this.getPassword()
            );

            PreparedStatement deleteStatement = deleteConnection.prepareStatement(
                    "DELETE FROM user_database.licensees WHERE licenseID = ?"
            );
            deleteStatement.setString(1, licenseID);
            deleteStatement.executeUpdate();
        } catch (SQLException srx) {
            srx.getStackTrace();
            JOptionPane.showMessageDialog(null,
                    "An error occurred while deleting licensee from database.\nPlease try again.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error while deleting licensee from database.");
        }
    }

    //checks for changes in table
    @Override
    public DefaultTableModel updateDatabase() {
        try {
            Connection updateConnection = DriverManager.getConnection(
                    this.getURL() + "/user_database",
                    this.getUsername(),
                    this.getPassword()
            );

            PreparedStatement updateStatement = updateConnection.prepareStatement(
                    "SELECT licenseID, LastName, FirstName, MiddleName, Sex, DateOfBirth, Weight, Height," +
                            " Address, CreationDate, ExpirationDate, Restrictions FROM user_database.licensees"
            );

            ResultSet updateResultSet = updateStatement.executeQuery();

            DefaultTableModel updateTableModel = buildTableModel(updateResultSet);

            return updateTableModel;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while updating database table.\nPlease try again.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error while refreshing database table.");
            return null;
        }
    }

    //creates table model for display
    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();

        for (int i=1; i <= columnCount; i++) {
            columnNames.add(metaData.getColumnLabel(i));
        }
        Vector<Vector<Object>> dataVector= new Vector<>();

        while (rs.next()) {
            Vector<Object> rowVector= new Vector<>();

            for(int j=1;j<=columnCount;j++){
                rowVector.add(rs.getObject(j));
            }
            dataVector.add(rowVector);
        }

        return new DefaultTableModel(dataVector,columnNames);
    }
}