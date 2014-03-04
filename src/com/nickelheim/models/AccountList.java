package com.nickelheim.models;

import java.util.HashMap;
import java.util.Map;

/**
 * This class stores all user accounts into a hashmap
 * and implements AccountModel
 * 
 * @author Nickelheim
 */
public class AccountList implements AccountModel {
	private static AccountList instance;
    private Map<String, Account> accountList;
    
    //Constructor
    private AccountList() {
        accountList = new HashMap<String, Account>();
    }
    
    public static AccountList getInstance() {
        if (instance == null) {
            instance = new AccountList();
        }
        return instance;
    }
    
    //Checks whether all fields have been filled out on the create account
    //page, and if so, calls addAccount method to store account into hashmap 
    @Override
    public boolean isValidCreateAccount(final String username,
            final String firstName, final String lastName, final String email,
            final double balance) {
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
        if (balance == 0) {
            return false;
        }
        addAccount(username, firstName, lastName, email, balance);
        return true;
    }
    
    //adds account containing username, firstName, lastName, and email to
    //hashmap
    @Override
    public void addAccount(String username, String firstName, String lastName,
    						String email, double balance) {
        accountList.put(username, new Account(username, firstName, lastName, email, balance));
    }
    
    public Account findAccount(String username) {
    	return accountList.get(username);
    }
    

}
