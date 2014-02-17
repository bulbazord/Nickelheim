package com.nickelheim;

public class UserVerification {
    private String username;
    private String password;
    
    public UserVerification(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isAdmin() {
        return username.equals("admin") && password.equals("pass123");
    }
}
