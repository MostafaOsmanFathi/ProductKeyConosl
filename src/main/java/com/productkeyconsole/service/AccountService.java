/*
 *  Copyright (c) 2024 Mostafa Osman
 *  All rights reserved.
 *
 *  This software and associated documentation files (the "Software") may not be
 *  used, copied, modified, merged, published, distributed, or sublicensed without
 *  explicit permission from the copyright owner.
 */
package com.productkeyconsole.service;

import com.productkeyconsole.model.account.Account;
import com.productkeyconsole.model.account.Address;
import com.productkeyconsole.model.account.CustomerAccount;
import com.productkeyconsole.model.account.SellerAccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.productkeyconsole.util.SaveToFile.SAVEINPATH;
/**
 * Service layer responsible for business logic related to account operations.
 *
 * <p>This class interacts with controllers and repositories to provide account-related services.
 *
 * @see Account
 * @version 1.0
 * @since 2024
 */
public class AccountService {

    private static final AccountService accountService = new AccountService();
    private static final ArrayList<Account> listOfAccounts = new ArrayList<>();
    private static Account loggedInAccount = null;
    static final String SellerFile = SAVEINPATH + "SellerAccount.txt";
    static final String CustomerFile = SAVEINPATH + "CustomerAccounts.txt";

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


    public void loadFromFileSeller() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(SellerFile));
        while (sc.hasNext()) {
            String name = sc.next();
            String email = sc.next();
            String password = sc.next();
            double balance = sc.nextDouble();
            String addressStreet = sc.next();
            String addressCity = sc.next();
            String addressState = sc.next();
            String addressZip = "---";
            AccountService acc = AccountService.getAccountService();
            Account tmp = new SellerAccount(name, email, password, balance, new Address(addressStreet, addressCity, addressState, addressZip));
            acc.createNewAccount(tmp);
        }
    }

    public void loadFromFileCustomer() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(CustomerFile));
        while (sc.hasNext()) {

            String name = sc.next();
            String email = sc.next();
            String password = sc.next();
            double balance = sc.nextDouble();
            String addressStreet = sc.next();
            String addressCity = sc.next();
            String addressState = sc.next();
            String addressZip = "----";
            AccountService acc = AccountService.getAccountService();
            Account tmp = new CustomerAccount(name, email, password, balance, new Address(addressStreet, addressCity, addressState, addressZip));
            acc.createNewAccount(tmp);
        }
    }

    public Account getLoggedInAccount() {
        return loggedInAccount;
    }
}

