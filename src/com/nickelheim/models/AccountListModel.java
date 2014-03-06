package com.nickelheim.models;

import java.util.List;

public interface AccountListModel {
    boolean isValidCreateAccount(final String accountName, final double
                                                                    balance);
    void addToList(Account account);
    List<Account> getList();
    Account getAccountByName(String accountName);
}
