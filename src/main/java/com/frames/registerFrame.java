package com.frames;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.login.APILoginInfo;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class registerFrame extends JFrame {
    private JPanel panel1;
    private JTextField newUsername;
    private JPasswordField newPassword;
    private JPasswordField checkNewPassword;
    private JButton registerNewAccountButton;
    private JLabel usernameInput;
    private JLabel passwordInput;
    private JLabel passwordCheck;
    private JPanel flavorText;
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JLabel topLabel;
    private JLabel bottomLabel;

    public registerFrame() {
        setTitle("Register");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        pack();

        registerNewAccountButton.addActionListener(e -> {
            String username = newUsername.getText();
            String password = new String(newPassword.getPassword());
            String checkPassword = new String(checkNewPassword.getPassword());

            if (password.equals(checkPassword)) {
                APILoginInfo register = new APILoginInfo();
                register.newAccount(username, password);
            } else {
                JOptionPane.showMessageDialog(null, "Passwords do not match. Try again.");
            }
        });
    }

    public static void main(String[] args) {
        new registerFrame();
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
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(3, 1, new Insets(15, 15, 15, 15), -1, -1));
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(inputPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        newUsername = new JTextField();
        inputPanel.add(newUsername, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        newPassword = new JPasswordField();
        inputPanel.add(newPassword, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        usernameInput = new JLabel();
        usernameInput.setText("Username:");
        inputPanel.add(usernameInput, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        checkNewPassword = new JPasswordField();
        inputPanel.add(checkNewPassword, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        passwordInput = new JLabel();
        passwordInput.setText("Password:");
        inputPanel.add(passwordInput, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordCheck = new JLabel();
        passwordCheck.setText("Confirm Password:");
        inputPanel.add(passwordCheck, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayoutManager(1, 1, new Insets(10, 0, 0, 0), -1, -1));
        panel1.add(buttonPanel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        registerNewAccountButton = new JButton();
        registerNewAccountButton.setText("Register New Account");
        buttonPanel.add(registerNewAccountButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_SOUTHEAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        flavorText = new JPanel();
        flavorText.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 15, 0), -1, -1));
        panel1.add(flavorText, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        topLabel = new JLabel();
        Font topLabelFont = this.$$$getFont$$$(null, Font.BOLD, 16, topLabel.getFont());
        if (topLabelFont != null) topLabel.setFont(topLabelFont);
        topLabel.setText("Sign Up");
        flavorText.add(topLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bottomLabel = new JLabel();
        bottomLabel.setText("Create a New Controller Account");
        flavorText.add(bottomLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        return panel1;
    }

}
