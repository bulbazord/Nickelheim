package com.nickelheim.models;

import java.util.ArrayList;
import java.util.List;

public class AccountList implements AccountListModel {
    private static AccountList instance;
    private List<Account> accountList;
    
    private AccountList() {
        accountList = new ArrayList<Account>();
    }
    
    public static AccountList getInstance() {
        if (instance == null) {
            instance = new AccountList();
        }
        return instance;
    }
    
    @Override
    public void addToList(Account account) {
        accountList.add(account);
    }
    
    @Override
    public List<Account> getList() {
        return accountList;
    }
    
    @Override
    public Account getAccountByName(String accountName) {
        for (Account account : accountList) {
            if (account.getAccountName().equals(accountName)) {
                return account;
            } 
        }
        return null;
    }
    
    //Checks whether all fields have been filled out on the create account
    //page, and if so, adds account to userAccountsList
    @Override
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
            return true;
        }
}
