package com.nickelheim.models;

 
/**
 * Interface to be implemented by AccountList.java
 * 
 * @author Nickelheim
 */
public interface AccountModel {
    boolean isValidCreateAccount(final String username, final String firstName, final String lastName, final String email);
    void addAccount(final String username, final String firstName, final String lastName, final String email);
}
