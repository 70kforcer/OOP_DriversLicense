/*
 * Created by JFormDesigner on Sat Dec 14 14:07:06 CST 2024
 */

package com.frames;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import com.formdev.flatlaf.intellijthemes.FlatGradiantoDarkFuchsiaIJTheme;
import com.jgoodies.forms.factories.*;
import net.miginfocom.swing.*;
import raven.datetime.component.date.*;

import com.login.APILoginInfo;
import com.manip.Licensee;

/**
 * @author Alec
 */
public class DatabaseForm extends JFrame {

    private APILoginInfo update = new APILoginInfo();

    public DatabaseForm() {
        FlatGradiantoDarkFuchsiaIJTheme.setup();
        initComponents();
        addNumericFilter(weight); //doesn't accept non-numeric inputs
        addNumericFilter(height); //likewise
        refreshTableData();
        picker.setEditor(birthdate);
        picker.setDateFormat("yyyy-MM-dd"); //sets date format
        picker.setDateSelectionAble(localDate //disables future dates in calendar
                -> !localDate.isAfter(LocalDate.now()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()
                -> new DatabaseForm().setVisible(true));
    }

    private void logoutMouseClicked(MouseEvent e) {
        this.dispose();
    }

    private void updateButtonClicked(ActionEvent e) {
        refreshTableData();
    }

    private void refreshTableData() {
            //update
            DefaultTableModel tableModel = update.updateDatabase();
            datatable.setModel(tableModel);

            //sorting
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableModel);
            datatable.setRowSorter(sorter);
    }

    private void addNumericFilter(JTextField textField) {
        AbstractDocument doc = (AbstractDocument) textField.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string != null && string.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text != null && text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }

    private void addEntryButtonClicked(ActionEvent e) {

        //validate basic input fields
        if (lastname.getText().isEmpty() || firstname.getText().isEmpty() || middlename.getText().isEmpty() ||
                (!radioMale.isSelected() && !radioFemale.isSelected()) ||
                weight.getText().isEmpty() || height.getText().isEmpty() || birthdate.getText().isEmpty() ||
                (!checkA.isSelected() && !checkB.isSelected() && !checkC.isSelected() && !checkD.isSelected()) ||
                address.getText().isEmpty()
        ) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all fields",
                    "Error", JOptionPane.ERROR_MESSAGE
            );
        } else {
            try {
                Licensee newDriver = getLicensee();

                //add entry to database
                update.addNewDriver(newDriver);
    
                //clear all fields
                lastname.setText("");
                firstname.setText("");
                middlename.setText("");
                radioMale.setSelected(false);
                radioFemale.setSelected(false);
                weight.setText("");
                height.setText("");
                birthdate.setText("");
                address.setText("");
                checkA.setSelected(false);
                checkB.setSelected(false);
                checkC.setSelected(false);
                checkD.setSelected(false);
    
                // Refresh the table to include the new entry
                refreshTableData();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Error while adding licensee: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private Licensee getLicensee() {
        Licensee newDriver = new Licensee();

        newDriver.setLicenseeLN(lastname.getText().trim());
        newDriver.setLicenseeFN(firstname.getText().trim());
        newDriver.setLicenseeMN(middlename.getText().trim());
        newDriver.setLicenseeSex(radioMale.isSelected() ? "Male" : "Female");
        newDriver.setLicenseeWT(weight.getText().trim());
        newDriver.setLicenseeHT(height.getText().trim());
        newDriver.setLicenseeDOB(birthdate.getText().trim());
        newDriver.setLicenseeADD(address.getText().trim());

        newDriver.setRST(checkA.isSelected(), checkB.isSelected(), checkC.isSelected(), checkD.isSelected());
        return newDriver;
    }

    private void viewButtonClicked(ActionEvent e) {
        mainpanel.setSelectedComponent(currentlicensees);
    }

    private void removeButtonClicked(ActionEvent e) {
        update.deleteDriver(removeEntryTF.getText().trim());
        refreshTableData();
        removeEntryTF.setText("");
        removeEntryTF.requestFocus();
    }

    private void removeEntryTFMouseClicked(MouseEvent e) {
        removeEntryTF.requestFocus();
        removeEntryTF.selectAll();
    }

    private void licenseetableStateChanged(ChangeEvent e) {
        //get current tab
        int selectedTabIndex = mainpanel.getSelectedIndex();

        //check if at datatable
        if (selectedTabIndex == mainpanel.indexOfComponent(currentlicensees)) {
            updatebutton.setEnabled(true);
        } else {
            updatebutton.setEnabled(false);
        }
    }

    public void setUsername(String username) {
        userlabel.setText(username);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Alec Buetre
        splitter = new JSplitPane();
        leftpanel = new JPanel();
        flavorUI = new JPanel();
        placeholder = new JLabel();
        userlabel = new JLabel();
        logout = new JPanel();
        logoutLabel = new JLabel();
        leftseparator1 = new JPanel();
        separator1 = new JSeparator();
        leftbuttons = new JPanel();
        view = new JButton();
        updatebutton = new JButton();
        leftseparator = new JPanel();
        separator2 = new JSeparator();
        leftbottom = new JPanel();
        innerleftbottom = new JPanel();
        remove = new JButton();
        removeEntryTF = new JTextField();
        rightlayeredpanel = new JLayeredPane();
        bottomPane = new JPanel();
        innerBottomPane = new JPanel();
        leftInfo = new JPanel();
        bottomheader = new JLabel();
        separator4 = new JSeparator();
        lnlabel = new JLabel();
        lastname = new JTextField();
        fnlabel = new JLabel();
        firstname = new JTextField();
        mnlabel = new JLabel();
        middlename = new JTextField();
        sxlabel = new JLabel();
        radioMale = new JRadioButton();
        radioFemale = new JRadioButton();
        bdpanel = new JPanel();
        bdlabel = new JLabel();
        birthdate = new JFormattedTextField();
        rightInfo = new JPanel();
        rightpanel = new JPanel();
        whitespace = new JLabel();
        separator5 = new JSeparator();
        charpanel = new JPanel();
        wtlabel = new JLabel();
        weight = new JTextField();
        htlabel = new JLabel();
        height = new JTextField();
        rstpanel = new JPanel();
        rstlabel = new JLabel();
        checkA = new JCheckBox();
        checkB = new JCheckBox();
        checkC = new JCheckBox();
        checkD = new JCheckBox();
        addresslabel = new JLabel();
        address = new JTextField();
        rightbuttons = new JPanel();
        clearBT = new JButton();
        addBT = new JButton();
        mainpanel = new JTabbedPane();
        dashtab = new JPanel();
        currentlicensees = new JPanel();
        tableScrollPane = new JScrollPane();
        datatable = new JTable();
        datepicker = new JDialog();
        picker = new DatePicker();

        //======== this ========
        setPreferredSize(new Dimension(1310, 720));
        setTitle("Database Controller");
        setIconImage(new ImageIcon(getClass().getResource("/logo.png")).getImage());
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets 0",
            // columns
            "[1362,fill]",
            // rows
            "[727]"));

        //======== splitter ========
        {
            splitter.setPreferredSize(new Dimension(1280, 720));
            splitter.setDividerSize(3);
            splitter.setDividerLocation(300);

            //======== leftpanel ========
            {
                leftpanel.setBorder(new EtchedBorder());
                leftpanel.setMaximumSize(new Dimension(300, 2147483647));
                leftpanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[395]"));

                //======== flavorUI ========
                {
                    flavorUI.setLayout(new MigLayout(
                        "insets 20 20 null 10,hidemode 3",
                        // columns
                        "[49,fill]" +
                        "[203,fill]" +
                        "[257,fill]",
                        // rows
                        "[]"));

                    //---- placeholder ----
                    placeholder.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
                    placeholder.setBorder(Borders.DIALOG_BORDER);
                    flavorUI.add(placeholder, "cell 0 0,alignx center,growx 0");

                    //---- userlabel ----
                    userlabel.setText("userLabel");
                    userlabel.setFont(new Font("Inter Semi Bold", Font.BOLD, 13));
                    flavorUI.add(userlabel, "cell 1 0,alignx center,growx 0");

                    //======== logout ========
                    {
                        logout.setLayout(new MigLayout(
                            "hidemode 3,alignx right",
                            // columns
                            "[fill]",
                            // rows
                            "[]"));

                        //---- logoutLabel ----
                        logoutLabel.setText("Log Out");
                        logoutLabel.setFont(new Font("Inter Semi Bold", Font.BOLD, 13));
                        logoutLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        logoutLabel.setForeground(new Color(0xccff66));
                        logoutLabel.setBorder(Borders.DLU2_BORDER);
                        logoutLabel.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                logoutMouseClicked(e);
                            }
                        });
                        logout.add(logoutLabel, "cell 0 0");
                    }
                    flavorUI.add(logout, "cell 2 0");
                }
                leftpanel.add(flavorUI, "cell 0 0");

                //======== leftseparator1 ========
                {
                    leftseparator1.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[491,fill]",
                        // rows
                        "[]"));
                    leftseparator1.add(separator1, "cell 0 0");
                }
                leftpanel.add(leftseparator1, "cell 0 1");

                //======== leftbuttons ========
                {
                    leftbuttons.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[458,fill]",
                        // rows
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]0" +
                        "[]"));

                    //---- view ----
                    view.setText("View Table");
                    view.setFont(view.getFont().deriveFont(view.getFont().getStyle() | Font.BOLD, view.getFont().getSize() + 3f));
                    view.addActionListener(e -> viewButtonClicked(e));
                    leftbuttons.add(view, "cell 0 1");

                    //---- updatebutton ----
                    updatebutton.setText("Update Table");
                    updatebutton.setFont(updatebutton.getFont().deriveFont(updatebutton.getFont().getStyle() | Font.BOLD, updatebutton.getFont().getSize() + 3f));
                    updatebutton.addActionListener(e -> updateButtonClicked(e));
                    leftbuttons.add(updatebutton, "cell 0 2");
                }
                leftpanel.add(leftbuttons, "cell 0 2");

                //======== leftseparator ========
                {
                    leftseparator.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[753,fill]",
                        // rows
                        "[]"));
                    leftseparator.add(separator2, "cell 0 0");
                }
                leftpanel.add(leftseparator, "cell 0 3");

                //======== leftbottom ========
                {
                    leftbottom.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[506,fill]",
                        // rows
                        "[352]" +
                        "[]"));

                    //======== innerleftbottom ========
                    {
                        innerleftbottom.setBorder(new EtchedBorder());
                        innerleftbottom.setLayout(new MigLayout(
                            "hidemode 3",
                            // columns
                            "[506,fill]",
                            // rows
                            "[]" +
                            "[]"));

                        //---- remove ----
                        remove.setText("Remove Entry");
                        remove.setFont(remove.getFont().deriveFont(remove.getFont().getStyle() | Font.BOLD, remove.getFont().getSize() + 3f));
                        remove.addActionListener(e -> removeButtonClicked(e));
                        innerleftbottom.add(remove, "cell 0 0,aligny bottom,growy 0");

                        //---- removeEntryTF ----
                        removeEntryTF.setFont(removeEntryTF.getFont().deriveFont(removeEntryTF.getFont().getStyle() | Font.ITALIC));
                        removeEntryTF.setText("Input License No. here");
                        removeEntryTF.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                removeEntryTFMouseClicked(e);
                            }
                        });
                        innerleftbottom.add(removeEntryTF, "cell 0 1");
                    }
                    leftbottom.add(innerleftbottom, "cell 0 1");
                }
                leftpanel.add(leftbottom, "cell 0 4,growy");
            }
            splitter.setLeftComponent(leftpanel);

            //======== rightlayeredpanel ========
            {
                rightlayeredpanel.setBorder(new EtchedBorder());

                //======== bottomPane ========
                {
                    bottomPane.setBorder(new EtchedBorder());
                    bottomPane.setLayout(new MigLayout(
                        "insets 0,hidemode 3,aligny top",
                        // columns
                        "[fill]",
                        // rows
                        "[]"));

                    //======== innerBottomPane ========
                    {
                        innerBottomPane.setLayout(new MigLayout(
                            "hidemode 3,aligny top",
                            // columns
                            "[382,center]0" +
                            "[0,fill]0" +
                            "[870,right]",
                            // rows
                            "[290]"));

                        //======== leftInfo ========
                        {
                            leftInfo.setLayout(new MigLayout(
                                "insets 0 10 0 0,hidemode 3,align right top",
                                // columns
                                "[1596,fill]",
                                // rows
                                "[]" +
                                "[]" +
                                "[]0" +
                                "[0]0" +
                                "[]0" +
                                "[0]0" +
                                "[]0" +
                                "[0]0" +
                                "[]0" +
                                "[]0" +
                                "[0]"));

                            //---- bottomheader ----
                            bottomheader.setText("Personal Information");
                            bottomheader.setFont(bottomheader.getFont().deriveFont(bottomheader.getFont().getStyle() | Font.BOLD, bottomheader.getFont().getSize() + 9f));
                            leftInfo.add(bottomheader, "cell 0 0,growx");
                            leftInfo.add(separator4, "cell 0 1");

                            //---- lnlabel ----
                            lnlabel.setText("Last Name");
                            lnlabel.setFont(lnlabel.getFont().deriveFont(lnlabel.getFont().getSize() + 4f));
                            leftInfo.add(lnlabel, "cell 0 2,growx");
                            leftInfo.add(lastname, "cell 0 3,growx,width 250,height 30,gapx null 150");

                            //---- fnlabel ----
                            fnlabel.setText("First Name");
                            fnlabel.setFont(fnlabel.getFont().deriveFont(fnlabel.getFont().getSize() + 4f));
                            leftInfo.add(fnlabel, "cell 0 4,growx");
                            leftInfo.add(firstname, "cell 0 5,growx,width 250,height 30,gapx null 150");

                            //---- mnlabel ----
                            mnlabel.setText("Middle Name");
                            mnlabel.setFont(mnlabel.getFont().deriveFont(mnlabel.getFont().getSize() + 4f));
                            leftInfo.add(mnlabel, "cell 0 6,growx");
                            leftInfo.add(middlename, "cell 0 7,growx,width 250,height 30,gapx null 150");

                            //---- sxlabel ----
                            sxlabel.setText("Sex");
                            sxlabel.setFont(sxlabel.getFont().deriveFont(sxlabel.getFont().getSize() + 4f));
                            leftInfo.add(sxlabel, "cell 0 8,alignx left,growx 0,gapx null 20");

                            //---- radioMale ----
                            radioMale.setText("Male");
                            radioMale.setBorder(Borders.DIALOG_BORDER);
                            leftInfo.add(radioMale, "cell 0 8,alignx left,growx 0");

                            //---- radioFemale ----
                            radioFemale.setText("Female");
                            radioFemale.setBorder(Borders.DIALOG_BORDER);
                            leftInfo.add(radioFemale, "cell 0 8,alignx left,growx 0,gapx null 200");

                            //======== bdpanel ========
                            {
                                bdpanel.setLayout(new MigLayout(
                                    "insets 0,hidemode 3",
                                    // columns
                                    "[fill]" +
                                    "[fill]",
                                    // rows
                                    "[]"));

                                //---- bdlabel ----
                                bdlabel.setText("Birth Date");
                                bdlabel.setFont(bdlabel.getFont().deriveFont(bdlabel.getFont().getSize() + 4f));
                                bdpanel.add(bdlabel, "cell 0 0,alignx left,growx 0,gapx 0");
                                bdpanel.add(birthdate, "cell 1 0,alignx left,growx 0,width 174");
                            }
                            leftInfo.add(bdpanel, "cell 0 9,alignx left,growx 0");
                        }
                        innerBottomPane.add(leftInfo, "cell 0 0,aligny top,growy 0");

                        //======== rightInfo ========
                        {
                            rightInfo.setLayout(new MigLayout(
                                "insets 0,hidemode 2,align left top",
                                // columns
                                "[469,fill]",
                                // rows
                                "[290]0" +
                                "[]"));

                            //======== rightpanel ========
                            {
                                rightpanel.setLayout(new MigLayout(
                                    "insets 0 0 null null",
                                    // columns
                                    "[278,fill]" +
                                    "[781,fill]",
                                    // rows
                                    "[]" +
                                    "[]" +
                                    "[]0" +
                                    "[]0" +
                                    "[]" +
                                    "[]0" +
                                    "[]" +
                                    "[]" +
                                    "[]"));

                                //---- whitespace ----
                                whitespace.setText("   ");
                                whitespace.setFont(whitespace.getFont().deriveFont(whitespace.getFont().getStyle() | Font.BOLD, whitespace.getFont().getSize() + 9f));
                                rightpanel.add(whitespace, "cell 0 0,growx");
                                rightpanel.add(separator5, "cell 0 1 2 1");

                                //======== charpanel ========
                                {
                                    charpanel.setLayout(new MigLayout(
                                        "",
                                        // columns
                                        "[261,fill]",
                                        // rows
                                        "[]0" +
                                        "[]0" +
                                        "[]0" +
                                        "[]"));

                                    //---- wtlabel ----
                                    wtlabel.setText("Weight in kilograms");
                                    wtlabel.setFont(wtlabel.getFont().deriveFont(wtlabel.getFont().getSize() + 4f));
                                    charpanel.add(wtlabel, "cell 0 0");
                                    charpanel.add(weight, "cell 0 1,width 200,height 20");

                                    //---- htlabel ----
                                    htlabel.setText("Height in centimeters");
                                    htlabel.setFont(htlabel.getFont().deriveFont(htlabel.getFont().getSize() + 4f));
                                    charpanel.add(htlabel, "cell 0 2");
                                    charpanel.add(height, "cell 0 3,width 200,height 20");
                                }
                                rightpanel.add(charpanel, "cell 0 2,aligny top,growy 0");

                                //======== rstpanel ========
                                {
                                    rstpanel.setLayout(new MigLayout(
                                        "hidemode 3",
                                        // columns
                                        "[fill]" +
                                        "[fill]",
                                        // rows
                                        "[]" +
                                        "[]" +
                                        "[]"));

                                    //---- rstlabel ----
                                    rstlabel.setText("Restrictions");
                                    rstlabel.setFont(rstlabel.getFont().deriveFont(rstlabel.getFont().getSize() + 4f));
                                    rstpanel.add(rstlabel, "cell 0 0,growx");

                                    //---- checkA ----
                                    checkA.setText("A (motorcycles/tricycles)");
                                    rstpanel.add(checkA, "cell 0 1,gapy 5 10");

                                    //---- checkB ----
                                    checkB.setText("B (cars/light trucks)");
                                    rstpanel.add(checkB, "cell 0 2");

                                    //---- checkC ----
                                    checkC.setText("C (large trucks)");
                                    rstpanel.add(checkC, "cell 1 1,gapy 5 10");

                                    //---- checkD ----
                                    checkD.setText("D (buses)");
                                    rstpanel.add(checkD, "cell 1 2");
                                }
                                rightpanel.add(rstpanel, "cell 1 2,grow");

                                //---- addresslabel ----
                                addresslabel.setText("Address");
                                addresslabel.setFont(addresslabel.getFont().deriveFont(addresslabel.getFont().getSize() + 4f));
                                rightpanel.add(addresslabel, "cell 0 4,growx,gapx 7");
                                rightpanel.add(address, "cell 0 5 2 1,growx,width 250,height 30,gapx 7 7");

                                //======== rightbuttons ========
                                {
                                    rightbuttons.setLayout(new MigLayout(
                                        "insets 0 0 null null,align right bottom",
                                        // columns
                                        "[781,fill]",
                                        // rows
                                        "[]"));

                                    //---- clearBT ----
                                    clearBT.setText("Clear");
                                    clearBT.setFont(clearBT.getFont().deriveFont(clearBT.getFont().getStyle() | Font.BOLD, clearBT.getFont().getSize() + 3f));
                                    rightbuttons.add(clearBT, "cell 0 0");

                                    //---- addBT ----
                                    addBT.setText("Add New Entry");
                                    addBT.setFont(addBT.getFont().deriveFont(addBT.getFont().getStyle() | Font.BOLD, addBT.getFont().getSize() + 3f));
                                    addBT.addActionListener(e -> addEntryButtonClicked(e));
                                    rightbuttons.add(addBT, "cell 0 0");
                                }
                                rightpanel.add(rightbuttons, "cell 1 7,align right bottom,grow 0 0");
                            }
                            rightInfo.add(rightpanel, "cell 0 0,aligny top,grow 100 0");
                        }
                        innerBottomPane.add(rightInfo, "cell 2 0");
                    }
                    bottomPane.add(innerBottomPane, "cell 0 0,aligny top,growy 0");
                }
                rightlayeredpanel.add(bottomPane, JLayeredPane.DEFAULT_LAYER);
                bottomPane.setBounds(0, 375, 995, 310);

                //======== mainpanel ========
                {
                    mainpanel.setBorder(new EtchedBorder());
                    mainpanel.addChangeListener(e -> licenseetableStateChanged(e));

                    //======== dashtab ========
                    {
                        dashtab.setLayout(new MigLayout(
                            "hidemode 3",
                            // columns
                            "[fill]",
                            // rows
                            "[]"));
                    }
                    mainpanel.addTab("Dashboard", dashtab);

                    //======== currentlicensees ========
                    {
                        currentlicensees.setLayout(new MigLayout(
                            "hidemode 3",
                            // columns
                            "[1229,fill]",
                            // rows
                            "[]"));

                        //======== tableScrollPane ========
                        {

                            //---- datatable ----
                            datatable.setModel(new DefaultTableModel(
                                new Object[][] {
                                    {null},
                                },
                                new String[] {
                                    null
                                }
                            ));
                            tableScrollPane.setViewportView(datatable);
                        }
                        currentlicensees.add(tableScrollPane, "cell 0 0");
                    }
                    mainpanel.addTab("Current Licensees", currentlicensees);
                }
                rightlayeredpanel.add(mainpanel, JLayeredPane.DEFAULT_LAYER);
                mainpanel.setBounds(0, 0, 995, 375);
            }
            splitter.setRightComponent(rightlayeredpanel);
        }
        contentPane.add(splitter, "cell 0 0");
        pack();
        setLocationRelativeTo(getOwner());

        //======== datepicker ========
        {
            datepicker.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            datepicker.setType(Window.Type.POPUP);
            var datepickerContentPane = datepicker.getContentPane();
            datepickerContentPane.setLayout(new MigLayout(
                "insets 0,hidemode 3,align center top",
                // columns
                "[328,fill]",
                // rows
                "[361]"));

            //---- picker ----
            picker.setCloseAfterSelected(true);
            datepickerContentPane.add(picker, "cell 0 0,grow");
            datepicker.setSize(331, 406);
            datepicker.setLocationRelativeTo(null);
        }

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioMale);
        buttonGroup1.add(radioFemale);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Alec Buetre
    private JSplitPane splitter;
    private JPanel leftpanel;
    private JPanel flavorUI;
    private JLabel placeholder;
    private JLabel userlabel;
    private JPanel logout;
    private JLabel logoutLabel;
    private JPanel leftseparator1;
    private JSeparator separator1;
    private JPanel leftbuttons;
    private JButton view;
    private JButton updatebutton;
    private JPanel leftseparator;
    private JSeparator separator2;
    private JPanel leftbottom;
    private JPanel innerleftbottom;
    private JButton remove;
    private JTextField removeEntryTF;
    private JLayeredPane rightlayeredpanel;
    private JPanel bottomPane;
    private JPanel innerBottomPane;
    private JPanel leftInfo;
    private JLabel bottomheader;
    private JSeparator separator4;
    private JLabel lnlabel;
    private JTextField lastname;
    private JLabel fnlabel;
    private JTextField firstname;
    private JLabel mnlabel;
    private JTextField middlename;
    private JLabel sxlabel;
    private JRadioButton radioMale;
    private JRadioButton radioFemale;
    private JPanel bdpanel;
    private JLabel bdlabel;
    private JFormattedTextField birthdate;
    private JPanel rightInfo;
    private JPanel rightpanel;
    private JLabel whitespace;
    private JSeparator separator5;
    private JPanel charpanel;
    private JLabel wtlabel;
    private JTextField weight;
    private JLabel htlabel;
    private JTextField height;
    private JPanel rstpanel;
    private JLabel rstlabel;
    private JCheckBox checkA;
    private JCheckBox checkB;
    private JCheckBox checkC;
    private JCheckBox checkD;
    private JLabel addresslabel;
    private JTextField address;
    private JPanel rightbuttons;
    private JButton clearBT;
    private JButton addBT;
    private JTabbedPane mainpanel;
    private JPanel dashtab;
    private JPanel currentlicensees;
    private JScrollPane tableScrollPane;
    private JTable datatable;
    private JDialog datepicker;
    private DatePicker picker;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
