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

    boolean isValidAccount(String accountName, double balance);

    void addAccount(Account acc);

    Account getAccountByName(String accName);

    User getUser();

    Collection<Account> getAccounts();
    
}
