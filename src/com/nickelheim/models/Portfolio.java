package com.nickelheim.models;

import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;
import java.util.ArrayList;


/**
 * This class represents a User's Portfolio, which holds some nuumber of
 * Accounts.
 *
 * Portfolios are tied to a unique User, and should only be loaded when that
 * User is logged in. They provide access to associated Accounts, which are
 * must have unique names in the Porfolio. The reason for this uniqueness
 * constraint is Database related. It is also for the most part to-be-coded.
 *
 * @author matthugs
 * @version 1.0
 */
@DatabaseTable(tableName = "portfolios")
public class Portfolio implements PortfolioModel {
    /**
     * accounts instance variable.
     */
    @ForeignCollectionField(eager = true)
    private Collection<Account> accounts;
    /**
     * user instance variable.
     */
    @DatabaseField(canBeNull = false, foreign = true, uniqueCombo = true)
    private User user;
    /**
     * id instance variable.
     */
    @DatabaseField(id = true)
    private int id;
    /**
     * portfolioName instance variable.
     */
    @DatabaseField(uniqueCombo = true)
    private String portfolioName;

    /**
     * For ORMLite! Don't use it for anything! Ignore errors about it!
     */
    Portfolio() {

    }
    /**
     * method to get id.
     * 
     * @return id is the id
     */
    public int getId() {
        return id;
    }

    /**
     * Constructs a new Portfolio object from scratch, tied to the specified
     * User and with the specified name.
     *
     * Check that the provided User has no Portfolio by that name before
     * creating this. Otherwise you are setting yourself up for some
     * SQLExceptions if you ever try to store store this in the database.
     *
     * @param userInput the user to which this object is tied
     * @param portName the name to be used when identifying the Portfolio
     */
    public Portfolio(User userInput, String portName) {
        this.user = userInput;
        this.portfolioName = portName;
        this.accounts = new ArrayList<Account>();
    }

    /**
     * Checks whether the given data would properly define an Account
     * which could then be added to this Portfolio.
     *
     * @param accountName the name of the account, to be checked against existing
     * accounts
     * @param balance the hypothetical initial balance for the account
     * @return boolean true if there are no name conflicts
     */
    public boolean isValidAccount(String accountName,
                                  double balance) {
        return true; // YO FIX ME FOOL
    }

    /**
     * Adds the specified Account to the Portfolio.
     *
     * Accounts should be checked for name conflicts with existing Accounts
     * before this method is called.
     *
     * @param acc the Account to be added.
     */
    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    /**
     * Finds the Account with the given name in this Portfolio.
     *
     * Not case sensitive right now for convenience. Don't count on it being
     * that way, though.
     *
     * @param accountName the name of the Account
     * @return Account with that name (should be unique)
     */
    public Account getAccountByName(String accountName) {
        Account returnAccount = null;
        for (Account acc : accounts) {
            if (acc.getAccountName().equalsIgnoreCase(accountName)) {
                returnAccount = acc;
            }
        }
        return returnAccount;
    }

    /**
     * Returns the User who owns this Portfolio.
     *
     * @return User the controlling User
     */
    public User getUser() {
        return user;
    }

    /**
     * Bad encapsulation!  Getter method for accounts.
     * 
     * @return collection of accounts
     */
    public Collection<Account> getAccounts() {
        return accounts;
    }

    /**
     * Returns the name of the portfolio.
     *
     * @return Name of the portfolio.
     */
    public String getPortfolioName() {
        return portfolioName;
    }
}
