/*
 * Created by JFormDesigner on Sat Dec 14 13:00:00 CST 2024
 */

package com.frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.formdev.flatlaf.FlatDarkLaf;
import net.miginfocom.swing.*;

/**
 * @author Alec
 */
public class LandingFrame extends JFrame {

    public LandingFrame() {
        FlatDarkLaf.setup();
        initComponents();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()
                -> new LandingFrame().setVisible(true));
    }

    //upper button behavior
    private void licensedUserButtonClicked(ActionEvent e) {
        JOptionPane.showMessageDialog(
                LandingFrame.this,
                "This feature is coming soon!",
                "Not yet implemented", JOptionPane.INFORMATION_MESSAGE);
    }

    //lower button behavior
    private void systemAdminButtonClicked(ActionEvent e) {
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
        loginForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setEnabled(false);
        this.setVisible(false);

        loginForm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                LandingFrame.this.setEnabled(true);
                LandingFrame.this.setVisible(true);
            }
        });
        loginForm.setVisible(true);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Alec Buetre
        landingFrameInnerPanel = new JPanel();
        flavorUI = new JPanel();
        logo = new JLabel();
        header = new JLabel();
        buttonPanel = new JPanel();
        label2 = new JLabel();
        licensedUserButton = new JButton();
        or = new JLabel();
        systemAdminButton = new JButton();

        //======== this ========
        setBackground(new Color(0xde7c7d));
        setIconImage(new ImageIcon(getClass().getResource("/logo.png")).getImage());
        setTitle("Department of Transportation | Landing");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets 0,hidemode 2",
            // columns
            "[680,fill]",
            // rows
            "[498]"));

        //======== landingFrameInnerPanel ========
        {
            landingFrameInnerPanel.setBackground(new Color(0xde7c7d));
            landingFrameInnerPanel.setLayout(new MigLayout(
                "filly,insets 0 5 0 5,hidemode 2,aligny top",
                // columns
                "[534,fill]",
                // rows
                "[151]" +
                "[232]"));

            //======== flavorUI ========
            {
                flavorUI.setBackground(new Color(0xde7c7d));
                flavorUI.setLayout(new MigLayout(
                    "hidemode 2",
                    // columns
                    "[555,fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]"));

                //---- logo ----
                logo.setIcon(new ImageIcon(getClass().getResource("/logo2.png")));
                flavorUI.add(logo, "cell 0 0,align center top,grow 0 0");

                //---- header ----
                header.setText("Department of Transportation");
                header.setFont(new Font("Bahnschrift", Font.BOLD, 18));
                header.setForeground(new Color(0x740938));
                header.setBackground(new Color(0xfde6d0));
                flavorUI.add(header, "pad 0,cell 0 1,alignx center,growx 0");
            }
            landingFrameInnerPanel.add(flavorUI, "cell 0 0,align center bottom,grow 0 0");

            //======== buttonPanel ========
            {
                buttonPanel.setBackground(new Color(0xde7c7d));
                buttonPanel.setLayout(new MigLayout(
                    "insets null null 100 null,hidemode 3,align center center",
                    // columns
                    "[420,fill]",
                    // rows
                    "[45]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- label2 ----
                label2.setText("Log In as a...");
                label2.setFont(new Font("Candara", Font.BOLD, 14));
                label2.setForeground(new Color(0x740938));
                buttonPanel.add(label2, "cell 0 0,alignx center,growx 0");

                //---- licensedUserButton ----
                licensedUserButton.setText("LICENSED USER");
                licensedUserButton.setFont(new Font("Candara", Font.BOLD, 14));
                licensedUserButton.setBackground(new Color(0x880c39));
                licensedUserButton.setForeground(new Color(0xedd7ca));
                licensedUserButton.addActionListener(e -> licensedUserButtonClicked(e));
                buttonPanel.add(licensedUserButton, "cell 0 1,align center center,grow 0 0,width 150:200,height 38");

                //---- or ----
                or.setText("or");
                or.setFont(new Font("Candara", Font.BOLD, 14));
                buttonPanel.add(or, "cell 0 2,alignx center,growx 0");

                //---- systemAdminButton ----
                systemAdminButton.setText("SYSTEM ADMIN");
                systemAdminButton.setFont(new Font("Candara", Font.BOLD, 14));
                systemAdminButton.setBackground(new Color(0x880c39));
                systemAdminButton.setForeground(new Color(0xedd7ca));
                systemAdminButton.addActionListener(e -> systemAdminButtonClicked(e));
                buttonPanel.add(systemAdminButton, "cell 0 3,align center center,grow 0 0,width 150:200,height 38");
            }
            landingFrameInnerPanel.add(buttonPanel, "cell 0 1,align center bottom,grow 0 0");
        }
        contentPane.add(landingFrameInnerPanel, "cell 0 0,growy");
        setSize(406, 487);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Alec Buetre
    private JPanel landingFrameInnerPanel;
    private JPanel flavorUI;
    private JLabel logo;
    private JLabel header;
    private JPanel buttonPanel;
    private JLabel label2;
    private JButton licensedUserButton;
    private JLabel or;
    private JButton systemAdminButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
