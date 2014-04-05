package com.nickelheim.models;

import java.util.Collection;

/**
 * Represents a Portfolio of Accounts that the User has stored in the system.
 *
 * Stores Accounts some kinda way, requestable by name.
 *
 * Each Portfolio corresponds to a particular User. As such they have a unique
 * username associated with them.
 */
public interface PortfolioModel {
    /**
     * Checks whether the given data would properly define an Account
     * which could then be added to this Portfolio.
     *
     * @param accountName the name of the account, to be checked against existing
     * accounts
     * @param balance the hypothetical initial balance for the account
     * @return boolean true if there are no name conflicts
     */
    boolean isValidAccount(String accountName, double balance);
    /**
     * Adds the specified Account to the Portfolio.
     *
     * Accounts should be checked for name conflicts with existing Accounts
     * before this method is called.
     *
     * @param acc the Account to be added.
     */
    void addAccount(Account acc);
    /**
     * Finds the Account with the given name in this Portfolio.
     *
     * Not case sensitive right now for convenience. Don't count on it being
     * that way, though.
     *
     * @param accountName the name of the Account
     * @return Account with that name (should be unique)
     */
    Account getAccountByName(String accountName);
    /**
     * Returns the User who owns this Portfolio.
     *
     * @return User the controlling User
     */
    User getUser();
    /**
     * Bad encapsulation!  Getter method for accounts.
     * 
     * @return collection of accounts
     */
    Collection<Account> getAccounts();
    
}
