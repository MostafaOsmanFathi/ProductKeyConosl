/*
 *  Copyright (c) 2024 Mostafa Osman
 *  All rights reserved.
 *
 *  This software and associated documentation files (the "Software") may not be
 *  used, copied, modified, merged, published, distributed, or sublicensed without
 *  explicit permission from the copyright owner.
 */
package com.productkeyconsole.control;

import com.productkeyconsole.model.account.Account;
import com.productkeyconsole.model.account.Address;
import com.productkeyconsole.model.account.CustomerAccount;
import com.productkeyconsole.model.account.SellerAccount;
import com.productkeyconsole.service.AccountService;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.productkeyconsole.view.ConsoleViewer.makeHeader;
import static com.productkeyconsole.view.ConsoleViewer.makeHeaderWithRows;
/**
 * Controls the logic related to account operations such as creating, deleting, or updating accounts.
 *
 * <p>This controller interacts with services and models to handle account-related actions.
 *
 * @see AccountService
 * @see CustomerAccount
 * @see SellerAccount
 *
 * @version 1.0
 * @since 2024
 */
public class AccountController {

    private static final Scanner scanner = new Scanner(System.in);
    static Account logedInAccount = null;
    private static final AccountService accountService = AccountService.getAccountService();


    static void depositController(Account account) {
        System.out.println("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) System.out.println("Deposit Successful");
        else {
            System.out.println("Deposit failed");
        }
    }

    static void withdrawController(Account account) {
        System.out.println("Enter deposit withdraw amount: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) System.out.println("withdraw Successful");
        else {
            System.out.println("withdraw failed");
        }
    }

    static void changePasswordController(Account account) {
        System.out.println("Enter old password: ");
        String oldPassword = scanner.next();

        System.out.println("Enter new password: ");
        String newPassword = scanner.next();

        if (account.ChangePassword(oldPassword, newPassword)) {
            System.out.println("Password Changed");
            return;
        }
        System.out.println("password changed failed");
    }

    static void showBalanceController(Account account) {
        makeHeaderWithRows("Account Balance", "Your balance is:" + "%.2f".formatted(account.getBalance()));
    }

    static void ShowAccountInfoController(Account account) {
        makeHeaderWithRows("Account Info", account.toString());
    }

    static void RemoveMyAccountController() {

    }

    static void logout() {
        makeHeader("Account Loged Out");
        accountService.logOutAccount();
        logedInAccount = null;
    }

    static void loginController() {
        makeHeader("Login to your Account");
        System.out.println("enter your email:");
        String email = scanner.next();
        System.out.println("enter your password:");
        String password = scanner.next();
        if (accountService.logInAccount(email, password)) {
            System.out.println("Logged in Successfully");
            logedInAccount = accountService.getLoggedInAccount();
            System.out.println("Welcome " + logedInAccount.getName());
        }
    }

    static void createAccountController() {
        makeHeader("Create Account");
        System.out.println("Enter account name: ");
        String name = scanner.next();

        System.out.println("Enter account Email: ");
        String email = scanner.next();

        System.out.println("Enter account password: ");
        String password = scanner.next();


        System.out.println("Enter account type: 1=>CustomerAccount 2=>SellerAccount");
        int AccountType = scanner.nextInt();

        System.out.println("Enter account street: ");
        String street = scanner.nextLine();

        System.out.println("Enter account city: ");
        String city = scanner.nextLine();

        System.out.println("Enter account state: ");
        String state = scanner.nextLine();

        System.out.println("Enter account zip: ");
        String zip = scanner.nextLine();

        Account tmp;
        if (AccountType == 1) {
            tmp = new CustomerAccount(name, email, password, new Address(street, city, state, zip));
        } else if (AccountType == 2) {
            tmp = new SellerAccount(name, email, password, new Address(street, city, state, zip));
        } else {
            System.out.println("Invalid Account Type");
            return;
        }
        accountService.createNewAccount(tmp);
    }


    static void login() {

        label:
        {
            while (true) {
                if (logedInAccount != null) {
                    if (logedInAccount instanceof SellerAccount acc) {
                        SellerController.sellerController(acc);
                    } else if (logedInAccount instanceof CustomerAccount acc) {
                        CustomerController.customerController(acc);
                    }

                } else {
                    makeHeaderWithRows("Welcome To Product Key Console", "Login To Account (Admin | Seller | Customer):", "Create Account:");


                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            loginController();
                            break;
                        case 2:
                            createAccountController();
                            break;
                        default:
                            break label;
                    }
                }
            }
        }
    }
}
