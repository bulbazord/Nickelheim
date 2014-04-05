package com.nickelheim.models;

import java.util.List;

/**
 * Interface for Account List.
 * 
 * @author Nickelheim
 *
 */
public interface AccountListModel {
    /**
     * method to determine if user input is valid for creating an account.
     * @param username is the username
     * @param accountName is the account name
     * @param balance is the balance
     * @return a boolean
     */
    boolean isValidCreateAccount(final String username, final String accountName, final double
                                                                    balance);
    /**
     * method to add an account to the account list.
     * 
     * @param account is the user's account
     */
    void addToList(Account account);
    /**
     * returns a user's list of accounts.
     * 
     * @param username is the username
     * @return a list of accounts
     */
    List<Account> getListByUsername(String username);
    /**
     * method to find an account by name.
     * 
     * @param accountName is the name of the account
     * @return an Account with the matching account name
     */
    Account getAccountByName(String accountName);
}
