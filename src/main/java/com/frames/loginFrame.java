package com.frames;

import com.intellij.uiDesigner.core.GridConstraints;   //writes build code for Gradle builder
import com.intellij.uiDesigner.core.GridLayoutManager; //

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.event.*;

import com.login.APILoginInfo;

public class loginFrame extends JFrame {
    private JPanel loginPanel;
    private JPanel textFieldPanel;
    private JPanel imagePanel;
    private JPanel buttonPanel;
    private JPanel labelPanel;
    private JPanel titlePanel;
    private JPanel apiCheckPanel;

    private JLabel usernameLabel;
    private JTextField usernameTF;
    private JLabel passwordLabel;
    private JPasswordField passwordTF;

    private JButton loginButton;
    private JButton registerButton;

    private JLabel loginPanelTitle;
    private JLabel image;

    private JLabel apiCheckLabel;

    private int flag = 0;
    private final APILoginInfo testConnection = new APILoginInfo();

    public loginFrame() {

        setContentPane(loginPanel);
        setTitle("Log In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        apiCheckLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        apiCheckLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (flag == 0) {
                    if (testConnection.testAivenConnection()) {
                        flag = 1;
                        apiCheckLabel.setText("Connected to API ✓");
                        apiCheckLabel.setForeground(Color.decode("#228B22"));
                        JOptionPane.showMessageDialog(
                                loginFrame.this,
                                "Test connection successful!");
                    } else {
                        flag = 2;
                        apiCheckLabel.setText("Connection failed! ✘");
                        apiCheckLabel.setForeground(Color.red);
                        JOptionPane.showMessageDialog(
                                loginFrame.this,
                                "Connection to Aiven failed!\nPlease contact your system administrator.");
                    }
                } else if (flag == 2) {
                    Object[] options = {"Yes", "No"};
                    int n = JOptionPane.showOptionDialog(
                            loginFrame.this,
                            "Check API again?",
                            "Query",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (n == 0) {
                        flag = 0;
                        apiCheckLabel.setForeground(Color.black);
                        apiCheckLabel.setText("Check API");
                    }
                }
            }
        });

        loginButton.addActionListener(e -> {
            String username = usernameTF.getText();
            String password = new String(passwordTF.getPassword());
            APILoginInfo loginInfo = new APILoginInfo();

            if (loginInfo.validate(username, password)) {
                JOptionPane.showMessageDialog(
                        loginFrame.this, "Log In Successful!");
            } else {
                JOptionPane.showMessageDialog(
                        loginFrame.this,
                        "Wrong username or password.",
                        "Log In: failed", JOptionPane.ERROR_MESSAGE
                );
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerFrame registerFrame = new registerFrame();
                loginFrame.this.setEnabled(false);

                registerFrame.addWindowListener(new WindowAdapter() {
                  @Override
                  public void windowClosing(WindowEvent e) {
                      super.windowClosing(e);
                      loginFrame.this.setEnabled(true);
                  }
                });
                registerFrame.setVisible(true);
            }
        });
        pack();
    }

    public static void main(String[] args) {
        new loginFrame();
    }


// ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ IDE GENERATED CODE ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
// XXXXXXXXXXXXXXXXXXXX  DO NOT INTERACT   XXXXXXXXXXXXXXXXXXXX


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayoutManager(4, 3, new Insets(15, 15, 15, 15), -1, -1));
        textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new GridLayoutManager(2, 2, new Insets(10, 0, 0, 0), -1, -1));
        loginPanel.add(textFieldPanel, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        usernameTF = new JTextField();
        usernameTF.setText("example123");
        textFieldPanel.add(usernameTF, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(158, -1), null, 0, false));
        passwordTF = new JPasswordField();
        passwordTF.setText("passwordexample");
        textFieldPanel.add(passwordTF, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(158, -1), null, 0, false));
        labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayoutManager(2, 1, new Insets(10, 0, 0, 0), -1, -1));
        loginPanel.add(labelPanel, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        usernameLabel = new JLabel();
        usernameLabel.setText("Username:");
        labelPanel.add(usernameLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordLabel = new JLabel();
        passwordLabel.setText("Password:");
        labelPanel.add(passwordLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayoutManager(1, 2, new Insets(5, 0, 0, 0), -1, -1));
        loginPanel.add(buttonPanel, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        loginButton = new JButton();
        loginButton.setText("Login");
        buttonPanel.add(loginButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(65, -1), new Dimension(65, -1), 0, false));
        registerButton = new JButton();
        registerButton.setText("Register");
        buttonPanel.add(registerButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(87, -1), new Dimension(87, -1), 0, false));
        imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        loginPanel.add(imagePanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        image = new JLabel();
        image.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
        image.setOpaque(true);
        image.setText("");
        imagePanel.add(image, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        loginPanel.add(titlePanel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        loginPanelTitle = new JLabel();
        loginPanelTitle.setText("Controller Login");
        titlePanel.add(loginPanelTitle, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        apiCheckPanel = new JPanel();
        apiCheckPanel.setLayout(new GridLayoutManager(1, 1, new Insets(15, 0, 0, 0), -1, -1));
        loginPanel.add(apiCheckPanel, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        apiCheckLabel = new JLabel();
        Font apiCheckLabelFont = this.$$$getFont$$$(null, -1, 11, apiCheckLabel.getFont());
        if (apiCheckLabelFont != null) apiCheckLabel.setFont(apiCheckLabelFont);
        apiCheckLabel.setText("Check API");
        apiCheckPanel.add(apiCheckLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_SOUTHEAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return loginPanel;
    }

}