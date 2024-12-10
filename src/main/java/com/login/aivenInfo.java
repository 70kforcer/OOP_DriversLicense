package com.login;

public interface aivenInfo {
    boolean testAivenConnection();
    boolean validate(String username, String password);
    void newAccount(String username, String password);
}