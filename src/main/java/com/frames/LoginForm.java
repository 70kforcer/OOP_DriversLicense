/*
 * Created by JFormDesigner on Wed Dec 11 23:24:42 CST 2024
 */

package com.frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import com.formdev.flatlaf.FlatDarkLaf;
import net.miginfocom.swing.*;

import com.login.APILoginInfo;

/**
 * @author Alec
 */
public class LoginForm extends JFrame {

    private int apiFlag = 0;
    private final APILoginInfo APIconnection = new APILoginInfo();

    public LoginForm() {
        FlatDarkLaf.setup();
        initComponents();
    }

    public static void main (String[] args) {
        SwingUtilities.invokeLater(()
                -> new LoginForm().setVisible(true));
    }

    //enables DatabaseForm by logging in
    private void loginButtonClicked(ActionEvent e) {
        String username = usernameTF.getText().trim();
        String password = new String(passwordTf.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields",
                    "Error", JOptionPane.ERROR_MESSAGE
            );
        } else {
            if (APIconnection.loginAccount(username, password)) {
                DatabaseForm databaseForm = new DatabaseForm();
                databaseForm.setUsername( username );
                databaseForm.setVisible(true);
                databaseForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setVisible(false);
                this.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Invalid username or password",
                        "Error", JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    //enables RegisterForm
    private void registerButtonClicked(ActionEvent e) {
        RegisterForm registerForm = new RegisterForm();
        registerForm.setVisible(true);
        registerForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setEnabled(false);
        this.setVisible(false);

        // sets behavior of the opened window's close button
        registerForm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                LoginForm.this.setEnabled(true);
                LoginForm.this.setVisible(true);
            }
        });
    }

    //listens for clicks on the 'Check API' label
    private void checkAPIMouseClicked(MouseEvent e) {
        if (apiFlag == 0) {

            // when connection is successful
            if (APIconnection.testAivenConnection()) {
                apiFlag = 1;
                checkAPI.setText("Connected to API ✓");
                checkAPI.setForeground(Color.decode("#0047AB"));
                JOptionPane.showMessageDialog(
                        this,
                        "Test connection successful!");

            //when connection fails
            } else {
                apiFlag = 2;
                checkAPI.setText("Connection failed! ✘");
                checkAPI.setForeground(Color.red);
                JOptionPane.showMessageDialog(
                        this,
                        "Connection to Aiven failed!\nPlease contact your system administrator.");
            }

        // when clicked again after a failure, resets the label
        } else if (apiFlag == 2) {
            Object[] options = {"Yes", "No"};
            int n = JOptionPane.showOptionDialog(
                    this,
                    "Check API again?",
                    "Query",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (n == 0) {
                apiFlag = 0;
                checkAPI.setForeground(Color.decode("#FFBF00"));
                checkAPI.setText("Check API");
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Alec Buetre
        splitter = new JSplitPane();
        leftPanel = new JPanel();
        flavorUI = new JPanel();
        headr = new JLabel();
        logo = new JLabel();
        loginTextFields = new JPanel();
        usernameLabel = new JLabel();
        usernameTF = new JTextField();
        passwordLabel = new JLabel();
        passwordTf = new JPasswordField();
        loginButtons = new JPanel();
        registerButton = new JButton();
        loginButton = new JButton();
        extras = new JPanel();
        checkAPI = new JLabel();
        rightPanel = new JPanel();
        splash_image = new JLabel();

        //======== this ========
        setTitle("Driver's License Registration | Admin System");
        setIconImage(new ImageIcon(getClass().getResource("/logo.png")).getImage());
        setResizable(false);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets 0,hidemode 2",
            // columns
            "[1143,fill]",
            // rows
            "[355]"));

        //======== splitter ========
        {
            splitter.setBorder(null);
            splitter.setDividerSize(0);
            splitter.setDividerLocation(300);
            splitter.setBackground(new Color(0xde7c7d));
            splitter.setVerifyInputWhenFocusTarget(false);
            splitter.setName("splitter");
            splitter.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

            //======== leftPanel ========
            {
                leftPanel.setBackground(new Color(0xde7c7d));
                leftPanel.setLayout(new MigLayout(
                    "hidemode 3,alignx right",
                    // columns
                    "[324,fill]",
                    // rows
                    "[262]" +
                    "[90]" +
                    "[]" +
                    "[253]0"));

                //======== flavorUI ========
                {
                    flavorUI.setBackground(new Color(0xde7c7d));
                    flavorUI.setLayout(new MigLayout(
                        "insets 50 null null null,hidemode 3,aligny bottom",
                        // columns
                        "[281,fill]",
                        // rows
                        "[46]" +
                        "[77]"));

                    //---- headr ----
                    headr.setText("Controller Log In");
                    headr.setFont(new Font("Bahnschrift", Font.BOLD, 18));
                    headr.setForeground(new Color(0x740938));
                    headr.setBackground(new Color(0xfde6d0));
                    flavorUI.add(headr, "pad 0,cell 0 1,alignx center,growx 0");

                    //---- logo ----
                    logo.setIcon(new ImageIcon(getClass().getResource("/logo2.png")));
                    flavorUI.add(logo, "cell 0 0,align center bottom,grow 0 0");
                }
                leftPanel.add(flavorUI, "cell 0 0");

                //======== loginTextFields ========
                {
                    loginTextFields.setBackground(new Color(0xde7c7d));
                    loginTextFields.setLayout(new MigLayout(
                        "hidemode 3,alignx center",
                        // columns
                        "[246,fill]",
                        // rows
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));

                    //---- usernameLabel ----
                    usernameLabel.setText("Username");
                    usernameLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
                    usernameLabel.setForeground(new Color(0x740938));
                    usernameLabel.setBackground(new Color(0xfde6d0));
                    loginTextFields.add(usernameLabel, "cell 0 0,gapx 20");

                    //---- usernameTF ----
                    usernameTF.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                    usernameTF.setForeground(new Color(0x740938));
                    usernameTF.setCaretColor(new Color(0x333333));
                    usernameTF.setBackground(new Color(0xf5c0ca));
                    loginTextFields.add(usernameTF, "cell 0 1,gapx 16 10");

                    //---- passwordLabel ----
                    passwordLabel.setText("Password");
                    passwordLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
                    passwordLabel.setForeground(new Color(0x740938));
                    passwordLabel.setBackground(new Color(0xfde6d0));
                    loginTextFields.add(passwordLabel, "cell 0 2,gapx 20");

                    //---- passwordTf ----
                    passwordTf.setForeground(new Color(0x740938));
                    passwordTf.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                    passwordTf.setCaretColor(new Color(0x333333));
                    passwordTf.setBackground(new Color(0xf5c0ca));
                    loginTextFields.add(passwordTf, "cell 0 3,gapx 16 10");
                }
                leftPanel.add(loginTextFields, "cell 0 1");

                //======== loginButtons ========
                {
                    loginButtons.setBackground(new Color(0xde7c7d));
                    loginButtons.setLayout(new MigLayout(
                        "hidemode 3,alignx center",
                        // columns
                        "[fill]" +
                        "[fill]",
                        // rows
                        "[155]"));

                    //---- registerButton ----
                    registerButton.setText("Register");
                    registerButton.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
                    registerButton.setBackground(new Color(0x880c39));
                    registerButton.setForeground(new Color(0xedd7ca));
                    registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    registerButton.addActionListener(e -> registerButtonClicked(e));
                    loginButtons.add(registerButton, "cell 0 0,alignx center,growx 0,width 100,height 30");

                    //---- loginButton ----
                    loginButton.setText("Log In");
                    loginButton.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
                    loginButton.setBackground(new Color(0x880c39));
                    loginButton.setForeground(new Color(0xedd7ca));
                    loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    loginButton.addActionListener(e -> loginButtonClicked(e));
                    loginButtons.add(loginButton, "cell 1 0,alignx center,growx 0,height 30");
                }
                leftPanel.add(loginButtons, "cell 0 2");

                //======== extras ========
                {
                    extras.setBackground(new Color(0xde7c7d));
                    extras.setLayout(new MigLayout(
                        "insets 0 0 5 5,hidemode 3,alignx right",
                        // columns
                        "[fill]",
                        // rows
                        "[131]"));

                    //---- checkAPI ----
                    checkAPI.setText("Check API");
                    checkAPI.setFont(new Font("Inter", Font.ITALIC, 12));
                    checkAPI.setBackground(new Color(0xff9999));
                    checkAPI.setForeground(new Color(0xffbf00));
                    checkAPI.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    checkAPI.setToolTipText("Checks Aiven database connection");
                    checkAPI.setFocusable(false);
                    checkAPI.setBorder(new EtchedBorder());
                    checkAPI.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            checkAPIMouseClicked(e);
                        }
                    });
                    extras.add(checkAPI, "cell 0 0,align right bottom,grow 0 0");
                }
                leftPanel.add(extras, "cell 0 3");
            }
            splitter.setLeftComponent(leftPanel);

            //======== rightPanel ========
            {
                rightPanel.setBackground(new Color(0xde7c7d));
                rightPanel.setLayout(new MigLayout(
                    "fill,insets 0,hidemode 3,alignx center",
                    // columns
                    "[694,fill]",
                    // rows
                    "[]"));

                //---- splash_image ----
                splash_image.setIcon(new ImageIcon(getClass().getResource("/login_splash.png")));
                splash_image.setNextFocusableComponent(checkAPI);
                rightPanel.add(splash_image, "cell 0 0,grow,gapy null 0");
            }
            splitter.setRightComponent(rightPanel);
        }
        contentPane.add(splitter, "cell 0 0,grow");
        setSize(1017, 550);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Alec Buetre
    private JSplitPane splitter;
    private JPanel leftPanel;
    private JPanel flavorUI;
    private JLabel headr;
    private JLabel logo;
    private JPanel loginTextFields;
    private JLabel usernameLabel;
    private JTextField usernameTF;
    private JLabel passwordLabel;
    private JPasswordField passwordTf;
    private JPanel loginButtons;
    private JButton registerButton;
    private JButton loginButton;
    private JPanel extras;
    private JLabel checkAPI;
    private JPanel rightPanel;
    private JLabel splash_image;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
