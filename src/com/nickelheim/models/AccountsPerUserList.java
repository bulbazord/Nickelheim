package com.nickelheim.models;

import java.util.ArrayList;
import java.util.List;

public class AccountsPerUserList implements AccountsPerUserModel {
    private static AccountsPerUserList instance;
    private List<Account> userAccountsList;
    
    private AccountsPerUserList() {
        userAccountsList = new ArrayList<Account>();
    }
    
    public static AccountsPerUserList getInstance() {
        if (instance == null) {
            instance = new AccountsPerUserList();
        }
        return instance;
    }
    
    public List<Account> getList() {
        return userAccountsList;
    }
    
    public void addToList(Account account) {
        userAccountsList.add(account);
    }
    
    public Account getAccountByName(String accountName) {
        for (Account account : userAccountsList) {
            if (account.getAccountName().equals(accountName)) {
                return account;
            } 
        }
        return null;
    }
    
    public Account getAccountByIndex(int i) {
        return userAccountsList.get(i);
    }
    
    //Checks whether all fields have been filled out on the create account
    //page, and if so, adds account to userAccountsList
    public boolean isValidCreateAccount(final String accountName, final double
                                                                    balance) {
        if (accountName.length() == 0) {
            return false;
        }
        if (balance == 0) {
            return false;
        }
            Account account = new Account(accountName, balance);
            addToList(account);
            
            //for (Account a : userAccountsList) {
            //    System.out.println(a.getAccountName());
            //    System.out.println(a.getBalance());
            //}
            
            //System.out.println(userAccountsList.size());
            
            return true;
        }
}
