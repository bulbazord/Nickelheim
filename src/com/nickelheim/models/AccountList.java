package com.nickelheim.models;

import java.util.HashMap;
import java.util.Map;

/**
 * This class stores all user accounts into a hashmap and implements
 * AccountModel.
 *
 * Stores key-value pairs of usernames to Account objects.
 * 
 * @author Nickelheim
 */
public class AccountList implements AccountModel {
    private Map<String, Account> accountList;
    
    /**
     * Constructs a new Account List, setting up the username-Account map using
     * a Hashmap.
     */
    public AccountList() {
        accountList = new HashMap<String, Account>();
    }
    
    //Checks whether all fields have been filled out on the create account
    //page, and if so, calls addAccount method to store account into hashmap 
    /**
     * Checks whether the given data can create a valid account.
     *
     * (This logic should be in the Account class)
     *
     * @param String username of the user presently logged in
     * @param String firstName the user's first name
     * @param String lastName the user's last name
     * @param String email the user's email address
     */
    @Override
    public boolean isValidCreateAccount(final String username, final String firstName, final String lastName, final String email) {
        if (username.length() == 0) {
            return false;
        }
        if (firstName.length() == 0) {
            return false;
        }
        if (lastName.length() == 0) {
            return false;
        }
        if (email.length() == 0) {
            return false;
        }
        addAccount(username, firstName, lastName, email);
        return true;
    }
    
    //adds account containing username, firstName, lastName, and email to
    //hashmap
    @Override
    public void addAccount(String username, String firstName, String lastName, String email) {
        accountList.put(username, new Account(username, firstName, lastName, email));
    }
    

}
