package com.example.tutorprototype1;

public class Account {
    // fields
    private String accountEmail;
    private String accountPassword;
    // constructors
    public Account() {}

    public Account(String email, String password) {
        this.accountEmail = email;
        this.accountPassword = password;
    }
    // properties
    public void setEmail(String email) {
        this.accountEmail = email;
    }
    public String getEmail() {
        return this.accountEmail;
    }
    public void setPassword(String password) {
        this.accountPassword = password;
    }
    public String getPassword() {
        return this.accountPassword;
    }
}
