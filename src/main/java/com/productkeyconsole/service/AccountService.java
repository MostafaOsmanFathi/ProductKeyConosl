package com.productkeyconsole.service;

import com.productkeyconsole.model.account.Account;

import java.util.ArrayList;

public class AccountService {

    private static final AccountService accountService = new AccountService();
    private static final ArrayList<Account> listOfAccounts = new ArrayList<>();
    private static Account loggedInAccount = null;

    private AccountService() {
    }

    public static AccountService getAccountService() {
        return accountService;
    }

    public boolean createNewAccount(Account account) {
        if (getAccountByEmail(account.getEmail()) != null) {
            return false;
        }
        listOfAccounts.add(account);
        return true;
    }

    public boolean logInAccount(String email, String password) {
        Account account = getAccountByEmail(email);
        if (account == null) {
            return false;
        }
        if (account.checkPassword(password)) {
            loggedInAccount = account;
            return true;
        }
        return false;
    }

    public void logOutAccount() {
        loggedInAccount = null;
    }

    public Account getAccountByEmail(String email) {
        for (Account account : listOfAccounts) {
            if (account.getEmail().equals(email)) {
                return account;
            }
        }
        return null;
    }

    public Account getLoggedInAccount() {
        return loggedInAccount;
    }

}

