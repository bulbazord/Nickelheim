package com.nickelheim.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;
import java.util.ArrayList;

/**
 * Class for User, which is created on the registration page.
 *
 * Users represent a person's account related to the application.
 * Each user has a collection of portfolios.
 * A user and their portfolios are only loaded when the person logs in.
 *
 * @author aphivantrakul
 * @author xiaobai
 */
@DatabaseTable(tableName = "users")
public class User {

    @ForeignCollectionField(eager = true)
    private Collection<Portfolio> portfolios;

    @DatabaseField(id = true)
    private String username;
    @DatabaseField
    private String password;

    /**
     * No-arg constructor required by ORMLite.
     *
     * Not used for anything in the Nickelheim application, just for use by 
     * external library classes.
     */
    User() {

    }
    
    /**
     * Constructs a new User object from scratch.
     * Password is NOT encrypted. Completely unsafe.
     *
     * @param username The user's username.
     * @param password The user's password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.portfolios = new ArrayList<Portfolio>();
    }

    /**
     * Creates a string representation of a User.
     * @return A string representation of the User.
     */
    public String toString() {
        return "username: " + getUsername() + " password: " + getPassword();
    }

    public Portfolio getPortfolioByName(String portfolioName) {
        Portfolio returnPortfolio = null;
        for (Portfolio port : portfolios) {
            if (port.getPortfolioName().equalsIgnoreCase(portfolioName)) {
                returnPortfolio = port;
            }
        }
        return port;
    }
    
    /**
     * Getter for Username.
     * @return Username of User.
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Getter for Password.
     * @return Password of User.
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     */
    public Collection<Portfolio> getPortfolios() {
        return portfolios;
    }

    /**
     * Checks whether or not the given Portfolio information 
     * would be okay to add.
     * A portfolio is okay to add if one does not exist
     * by the same name already.
     *
     * @return True if portfolio doesn't already exist.
     */
    public boolean isValidPortfolio(String portName) {
        return !portfolios.contains(portName);
    }

    /**
     * Adds the specified Portfolio to the User's portfolios.
     *
     * Portfolio should be checked for validity before this is called.
     *
     * @param port The portfolio to be added.
     */
    public void addPortfolio(Portfolio port) {
        portfolios.add(port);
    }
}
