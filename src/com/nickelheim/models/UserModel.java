package com.nickelheim.models;

public interface UserModel {
    boolean isValidUser(final String username, final String password);
    boolean isValidRegistration(final String username, final String password);
    void addUser(final String username, final String password);
}
