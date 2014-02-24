package com.nickelheim.models;

import java.util.HashMap;
import java.util.Map;

public class AccountList implements AccountModel {
    private Map<String, Account> accountList;
    
    public AccountList() {
        accountList = new HashMap<String, Account>();
    }
    
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
    
    @Override
    public void addAccount(String username, String firstName, String lastName, String email) {
        accountList.put(username, new Account(username, firstName, lastName, email));
    }
    

}
