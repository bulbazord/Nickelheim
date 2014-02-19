package com.nickelheim.models;

public interface Model {
    boolean isValidUser(final String username, final String password);
    boolean isValidRegistration(final String username, final String password);
    void addUser(final String username, final String password);
}
