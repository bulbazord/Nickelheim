package com.nickelheim.models;

public interface Model {
    boolean isValidUser(final String username, final String password);
    void addUser(User user);
}
