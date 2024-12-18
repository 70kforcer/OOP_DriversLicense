/*
 * Created by JFormDesigner on Sat Dec 14 14:21:25 CST 2024
 */

package com.frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.formdev.flatlaf.FlatDarkLaf;
import com.login.APILoginInfo;
import net.miginfocom.swing.*;

/**
 * @author Alec
 */
public class RegisterForm extends JFrame {

    public RegisterForm() {
        FlatDarkLaf.setup();
        initComponents();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()
                -> new RegisterForm().setVisible(true));
    }

    //New Account button behavior
    private void newAccountButtonClicked(ActionEvent e) {
        APILoginInfo register = new APILoginInfo();

        String username = usernameTF.getText().trim();
        String password = new String(passwordTF.getPassword()).trim();
        String confirmPassword = new String(confirmPasswordTF.getPassword()).trim();

        // checks if text fields are empty
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            notificationArea.setText("Please fill all fields");

        // checks if username length is appropriate
        } else if (username.length() < 3) {
            notificationArea.setText("Username must be at least 3 characters long");

        // checks if passwords are matching or the appropriate length
        } else if (password.equals(confirmPassword)) {
            if (password.length() < 4) {
                notificationArea.setText("Password must be at least 4 characters long");
                passwordTF.setText("");
                confirmPasswordTF.setText("");
            } else if (register.newAccount(username, password)) {
                JOptionPane.showMessageDialog(
                        rootPane,
                        "Successfully registered a new account.",
                        "Success", JOptionPane.INFORMATION_MESSAGE
                );
                usernameTF.setText("");
                passwordTF.setText("");
                confirmPasswordTF.setText("");
                notificationArea.setText("");
            } else {
                JOptionPane.showMessageDialog(
                        rootPane,
                        "Error in creating an account\n",
                        "Error", JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            notificationArea.setText("Passwords do not match");
            passwordTF.setText("");
            confirmPasswordTF.setText("");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Alec Buetre
        registerFormInnerPanel = new JPanel();
        flavorUI = new JPanel();
        header1 = new JLabel();
        header2 = new JLabel();
        textFieldPanel = new JPanel();
        usernameLabel = new JLabel();
        usernameTF = new JTextField();
        passwordLabel = new JLabel();
        passwordTF = new JPasswordField();
        confirmPasswordLabel = new JLabel();
        confirmPasswordTF = new JPasswordField();
        notificationArea = new JTextArea();
        bottomPanel = new JPanel();
        newAccountButton = new JButton();

        //======== this ========
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/logo.png")).getImage());
        setTitle("Sign Up | Register");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets 0,hidemode 3",
            // columns
            "[fill]",
            // rows
            "[]"));

        //======== registerFormInnerPanel ========
        {
            registerFormInnerPanel.setBackground(new Color(0xde7c7d));
            registerFormInnerPanel.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[362,fill]",
                // rows
                "[]" +
                "[75]" +
                "[159]"));

            //======== flavorUI ========
            {
                flavorUI.setBackground(new Color(0xde7c7d));
                flavorUI.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[413,fill]",
                    // rows
                    "[]" +
                    "[]"));

                //---- header1 ----
                header1.setText("Sign Up");
                header1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
                header1.setForeground(new Color(0x740938));
                flavorUI.add(header1, "cell 0 0,alignx center,growx 0");

                //---- header2 ----
                header2.setText("Create a New Controller Account");
                header2.setFont(new Font("Bahnschrift", Font.BOLD, 14));
                header2.setForeground(new Color(0x740938));
                flavorUI.add(header2, "cell 0 1,alignx center,growx 0");
            }
            registerFormInnerPanel.add(flavorUI, "cell 0 0");

            //======== textFieldPanel ========
            {
                textFieldPanel.setBackground(new Color(0xde7c7d));
                textFieldPanel.setLayout(new MigLayout(
                    "insets null 35 null 35,hidemode 3",
                    // columns
                    "[301,fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- usernameLabel ----
                usernameLabel.setText("New Username");
                usernameLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
                usernameLabel.setForeground(new Color(0x740938));
                textFieldPanel.add(usernameLabel, "cell 0 0");

                //---- usernameTF ----
                usernameTF.setBackground(new Color(0xf5c0ca));
                usernameTF.setForeground(new Color(0x740938));
                textFieldPanel.add(usernameTF, "cell 0 1,growx");

                //---- passwordLabel ----
                passwordLabel.setText("Password");
                passwordLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
                passwordLabel.setForeground(new Color(0x740938));
                textFieldPanel.add(passwordLabel, "cell 0 2");

                //---- passwordTF ----
                passwordTF.setBackground(new Color(0xf5c0ca));
                passwordTF.setForeground(new Color(0x740938));
                textFieldPanel.add(passwordTF, "cell 0 4,growx");

                //---- confirmPasswordLabel ----
                confirmPasswordLabel.setText("Confirm Password");
                confirmPasswordLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
                confirmPasswordLabel.setForeground(new Color(0x740938));
                textFieldPanel.add(confirmPasswordLabel, "cell 0 5");

                //---- confirmPasswordTF ----
                confirmPasswordTF.setBackground(new Color(0xf5c0ca));
                confirmPasswordTF.setForeground(new Color(0x740938));
                textFieldPanel.add(confirmPasswordTF, "cell 0 7,growx");

                //---- notificationArea ----
                notificationArea.setBackground(new Color(0xde7c7d));
                notificationArea.setBorder(null);
                notificationArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                notificationArea.setFocusable(false);
                notificationArea.setForeground(new Color(0x740938));
                notificationArea.setMaximumSize(new Dimension(225, 35));
                notificationArea.setLineWrap(true);
                notificationArea.setColumns(1);
                notificationArea.setRows(1);
                notificationArea.setWrapStyleWord(true);
                textFieldPanel.add(notificationArea, "cell 0 8,aligny top,grow 100 0");
            }
            registerFormInnerPanel.add(textFieldPanel, "cell 0 1,alignx left,growx 0");

            //======== bottomPanel ========
            {
                bottomPanel.setBackground(new Color(0xde7c7d));
                bottomPanel.setName("panel1");
                bottomPanel.setLayout(new MigLayout(
                    "insets null null 10 35 35 35,hidemode 2,alignx right",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]"));

                //---- newAccountButton ----
                newAccountButton.setText("Register New Account");
                newAccountButton.setBackground(new Color(0x880c39));
                newAccountButton.setForeground(new Color(0xedd7ca));
                newAccountButton.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
                newAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                newAccountButton.addActionListener(e -> newAccountButtonClicked(e));
                bottomPanel.add(newAccountButton, "cell 3 2,aligny top,growy 0");
            }
            registerFormInnerPanel.add(bottomPanel, "cell 0 2,aligny bottom,growy 0");
        }
        contentPane.add(registerFormInnerPanel, "cell 0 0");
        setSize(325, 382);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Alec Buetre
    private JPanel registerFormInnerPanel;
    private JPanel flavorUI;
    private JLabel header1;
    private JLabel header2;
    private JPanel textFieldPanel;
    private JLabel usernameLabel;
    private JTextField usernameTF;
    private JLabel passwordLabel;
    private JPasswordField passwordTF;
    private JLabel confirmPasswordLabel;
    private JPasswordField confirmPasswordTF;
    private JTextArea notificationArea;
    private JPanel bottomPanel;
    private JButton newAccountButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
