package com.login;

public abstract class aivenLogin implements aivenInfo {
    public abstract boolean testAivenConnection();
    public abstract boolean validate(String username, String password);
    public abstract boolean newAccount(String username, String password);
}
