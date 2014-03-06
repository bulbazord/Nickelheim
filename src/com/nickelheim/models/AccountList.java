package com.nickelheim.models;

import java.util.HashMap;
import java.util.Map;

/**
 * This class stores all UserAccountsList into a hashmap
 * 
 * @author Nickelheim
 */
public class AccountList {
	private static AccountList instance;
    private Map<String, AccountsPerUserList> accountList;
    
    //Constructor
    private AccountList() {
        accountList = new HashMap<String, AccountsPerUserList>();
    }
    
    public static AccountList getInstance() {
        if (instance == null) {
            instance = new AccountList();
        }
        return instance;
    }
    
    /**
    //Checks whether all fields have been filled out on the create account
    //page, and if so, calls addAccount method to store account into hashmap 
    @Override
    public boolean isValidCreateAccount(final String username,
                            final String accountName, final String accountType,
                                                        final double balance) {
        if (username.length() == 0) {
            return false;
        }
        if (accountName.length() == 0) {
            return false;
        }
        if (accountType.length() == 0) {
            return false;
        }
        if (balance == 0) {
            return false;
        }
        addAccount(username, accountName, accountType, balance);
        return true;
    }
    
    */

    public void addAccountsPerUserList(String username) {
        accountList.put(username, AccountsPerUserList.getInstance());
    }
    
    public AccountsPerUserList findUserAccountsList(String username) {
    	return accountList.get(username);
    }
    

}
