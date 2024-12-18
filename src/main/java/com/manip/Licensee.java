package com.manip;

import java.util.ArrayList;

public class Licensee {
    String licenseeLN;
    String licenseeFN;
    String licenseeMN;
    String licenseeDOB;
    String licenseeSex;
    String licenseeWT;
    String licenseeHT;
    String licenseeADD;
    ArrayList<String> licenseeRST;

    public String getLicenseeLN() {
        return this.licenseeLN;
    }
    public void setLicenseeLN(String lastname) {
        this.licenseeLN = lastname;
    }

    public String getLicenseeFN() {
        return this.licenseeFN;
    }
    public void setLicenseeFN(String licenseeFN) {
        this.licenseeFN = licenseeFN;
    }

    public String getLicenseeMN() {
        return this.licenseeMN;
    }
    public void setLicenseeMN(String licenseeMN) {
        this.licenseeMN = licenseeMN;
    }

    public String getLicenseeDOB() {
        return this.licenseeDOB;
    }
    public void setLicenseeDOB(String licenseeDOB) {
        this.licenseeDOB = licenseeDOB;
    }

    public String getLicenseeSex() {
        return this.licenseeSex;
    }
    public void setLicenseeSex(String licenseeSex) {
        this.licenseeSex = licenseeSex;
    }

    public String getLicenseeHT() {
        return this.licenseeHT;
    }
    public void setLicenseeHT(String licenseeHT) {
        this.licenseeHT = licenseeHT;
    }

    public String getLicenseeWT() {
        return this.licenseeWT;
    }
    public void setLicenseeWT(String licenseeWT) {
        this.licenseeWT = licenseeWT;
    }

    public String getLicenseeADD() {
        return this.licenseeADD;
    }
    public void setLicenseeADD(String licenseeADD) {
        this.licenseeADD = licenseeADD;
    }

    public ArrayList<String> getRST() {
        return this.licenseeRST;
    }
    public void setRST (boolean a, boolean b, boolean c, boolean d) {
        ArrayList<String> licenseeRST = new ArrayList<>();
        if (a) licenseeRST.add("A");
        if (b) licenseeRST.add("B");
        if (c) licenseeRST.add("C");
        if (d) licenseeRST.add("D");
        this.licenseeRST = licenseeRST;
    }
    public String formatRST() {
        String[] RST = this.getRST().toArray(new String[0]);
        StringBuilder formatted = new StringBuilder();

        for (int i = 0; i < RST.length; i++) {
            formatted.append(RST[i]);
            if (i < RST.length - 1) {
                formatted.append(",");
            }
        }
        return formatted.toString();
    }

    public Licensee() {}
}