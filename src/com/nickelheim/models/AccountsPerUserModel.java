package com.nickelheim.models;

public interface AccountsPerUserModel {
    boolean isValidCreateAccount(final String accountName, final double
                                                                    balance);
    //Account findAccount(final String username);
}
