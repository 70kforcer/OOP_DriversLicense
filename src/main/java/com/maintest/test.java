package com.maintest;

import com.login.APILoginInfo;

public class test {
    public static void main(String[] args) {
        String URL = System.getProperty("databaseURL");
        String USERNAME = System.getProperty("databaseUSERNAME");
        String PASSWORD = System.getProperty("databasePASSWORD");

        APILoginInfo test = new APILoginInfo();
        test.setUsername(USERNAME);
        test.setPassword(PASSWORD);
        test.setURL(URL);
        test.testAivenConnection();
    }
}