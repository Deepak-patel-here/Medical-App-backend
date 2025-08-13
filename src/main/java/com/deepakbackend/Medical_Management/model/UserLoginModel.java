package com.deepakbackend.Medical_Management.model;

public class UserLoginModel {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserLoginModel() {
    }
}
