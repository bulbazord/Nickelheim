package com.nickelheim.models;

/**
 * Interface to be implemented by UserList.java.
 * 
 * @author Nickelheim
 */
public interface UserModel {
    /**
     * checks whether information passed to log in user is not empty and whether
     * the username passed in matches the password in the hashmap
     * maybe should also add if statement to check first if username is found in
     * hashmap.
     *
     * @param username is the username
     * @param password is the password
     * @return is a boolean
     */
    boolean isValidUser(final String username, final String password);
    /**
     * checks whether fields on registration page are empty when page is
     * submitted.  Also checks whether username has already been taken.
     * if information passes, the new User object is created and added to the
     * hashmap
     * 
     * @param username is the username
     * @param password is the password
     * @return is a boolean
     */
    boolean isValidRegistration(final String username, final String password);
    /**
     * adds user to the list.
     * 
     * @param username is the username
     * @param password is the password
     */
    void addUser(final String username, final String password);
}
