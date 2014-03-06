package com.nickelheim.models;

 
/**
 * Interface to be implemented by AccountList.java.
 * 
 * @author Nickelheim
 */
public interface AccountModel {
    boolean isValidCreateAccount(final String username,
                                final String accountName, final double balance);
    void addAccount(final String username, final String accountName,
                                                        final double balance);
    Account findAccount(final String username);
}
