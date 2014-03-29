package com.nickelheim.models;

import java.util.List;

public interface AccountListModel {
    boolean isValidCreateAccount(final String username, final String accountName, final double
                                                                    balance);
    void addToList(Account account);
    List<Account> getListByUsername(String username);
    Account getAccountByName(String accountName);
}
