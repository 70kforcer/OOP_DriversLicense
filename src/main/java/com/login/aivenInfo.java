package com.login;

public interface aivenInfo {
    boolean testAivenConnection();
    boolean validate(String username, String password);
    boolean newAccount(String username, String password);
}