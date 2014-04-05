package com.nickelheim.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of Accounts.
 * 
 * @author Nickelheim
 *
 */
public class AccountList implements AccountListModel {
    /**
     * instance instance variable.
     */
    private static AccountList instance;
    /**
     * accountList instance variable.
     */
    private List<Account> accountList;
    /**
     * constructor to create a new accountList.
     */
    private AccountList() {
        accountList = new ArrayList<Account>();
    }
    /**
     * method to return an instance of AccountList class.
     * 
     * @return AccountList
     */
    public static AccountList getInstance() {
        if (instance == null) {
            instance = new AccountList();
        }
        return instance;
    }
    /**
     * method to add an account to the account list.
     * 
     * @param account is the user's account
     */
    @Override
    public void addToList(Account account) {
        accountList.add(account);
    }
    
    @Override
    public List<Account> getListByUsername(String username) {
    	List<Account> accountListByUsername = new ArrayList<Account>();
    	for (Account account : accountList) {
    	    if (account.getUsername().equals(username)) {
    	        accountListByUsername.add(account);
    	    }
    	}
    	return accountListByUsername;
    }
    /**
     * method to find an account by name.
     * 
     * @param accountName is the name of the account
     * @return an Account with the matching account name
     */
    @Override
    public Account getAccountByName(String accountName) {
        for (Account account : accountList) {
            if (account.getAccountName().equals(accountName)) {
                return account;
            } 
        }
        return null;
    }
    /**
     * method to determine if user input is valid for creating an account.
     * @param username is the username
     * @param accountName is the account name
     * @param balance is the balance
     * @return a boolean
     */
    @Override
    public boolean isValidCreateAccount(final String username, final String accountName, final double
                                                                    balance) {
        if (accountName.length() == 0) {
            return false;
        }
        if (balance == 0) {
            return false;
        }
        // Account account = new Account(username, accountName, balance);
        // addToList(account);        
        return true;
    }
}
