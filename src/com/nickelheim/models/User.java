package com.nickelheim.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.ForeignCollectionField;

/**
 * Class for User, which is created on the registration page
 *
 * @author aphivantrakul
 */
@DatabaseTable(tableName = "users")
public class User {

    @DatabaseField(id = true)
    private String username;
    @DatabaseField
    private String password;

    
    @ForeignCollectionField(eager = true) //Will also need to set maxEagerLevel
    private Collection<Portfolio> portfolios;

    /**
     * No-arg constructor required by ORMLite.
     *
     * Not used for anything in the Nickelheim application, just for use by 
     * external library classes.
     */
    User() {

    }
    
    //Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.porfolios = new ArrayList<Portfolio>();
    }
    //toString to print out instance variables in a pretty way
    //this method is not currently being used
    public String toString() {
        return "username: " + getUsername() + " password: " + getPassword();
    }
    
    //getter for username instance variable
    public String getUsername() {
        return username;
    }
    
    //getter for password instance variable
    public String getPassword() {
        return password;
    }

    /**
     * This is bad encapsulation. Since you're lookin' at it, fix it.
     * (I was in a hurry)
     */
    public Collection<Portfolio> getPortfolio() {
        return portfolios;
    }
}
