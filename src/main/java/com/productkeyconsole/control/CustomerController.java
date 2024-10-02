/*
 *  Copyright (c) 2024 Mostafa Osman
 *  All rights reserved.
 *
 *  This software and associated documentation files (the "Software") may not be
 *  used, copied, modified, merged, published, distributed, or sublicensed without
 *  explicit permission from the copyright owner.
 */
package com.productkeyconsole.control;

import com.productkeyconsole.model.account.CustomerAccount;
import com.productkeyconsole.model.productkey.ProductKey;
import com.productkeyconsole.service.CustomerService;

import java.util.Scanner;

import static com.productkeyconsole.view.ConsoleViewer.makeHeaderWithRows;
import static com.productkeyconsole.control.AccountController.*;
/**
 * Handles customer-specific operations such as account management, order history, and product key retrieval.
 *
 * <p>This controller ensures customers can interact with their accounts efficiently.
 *
 * @see CustomerAccount
 * @see CustomerService
 *
 * @version 1.0
 * @since 2024
 */
public class CustomerController {
    private static final Scanner scanner = new Scanner(System.in);

    static void showProductOfTheStoreController() {
        var tmp = ProductKey.getListOfKeysOfTheStore();
        makeHeaderWithRows("list of Keys Over The Store", tmp.toArray(new String[0]));
    }

    static void selectProductOfTheStoreController(CustomerAccount customerAccount) {
        showProductOfTheStoreController();
        System.out.println("Enter Name of the Product Key");
        String Name = scanner.next();
        ProductKey tmp = ProductKey.getProductKeyByName(Name);
        if (tmp != null && CustomerService.buyProductKeyForCustomer(customerAccount, tmp)) {
            System.out.println("buy Successfully");
            return;
        }
        System.out.println("buy Process failed");
    }

    static void showMyKeyLiberayController(CustomerAccount account) {
        makeHeaderWithRows("Show Libearry of Keys", CustomerAccount.getListOfKeysInfoForLib(account));
    }

    static void customerController(CustomerAccount customerAccount) {
        label:
        {
            while (logedInAccount != null) {
                makeHeaderWithRows("Customer Account Choices\t\t\t\t\t\t" + customerAccount.getName(), "Deposit to your Account", "WithDraw to your Account", "Change Password", "Show Balance", "Account Information", "Remove My Account", "logout", "---", "Show Products of the store:", "Select Product by Name:", "Show My Products liberary:");
                System.out.println("enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        depositController(customerAccount);
                        break;
                    case 2:
                        withdrawController(customerAccount);
                        break;
                    case 3:
                        changePasswordController(customerAccount);
                        break;
                    case 4:
                        showBalanceController(customerAccount);
                        break;
                    case 5:
                        ShowAccountInfoController(customerAccount);
                        break;
                    case 6:
                        RemoveMyAccountController();
                        break;
                    case 7:
                        logout();
                        break label;
                    case 8:
                        showProductOfTheStoreController();
                        break;
                    case 9:
                        selectProductOfTheStoreController(customerAccount);
                    case 10:
                        showMyKeyLiberayController(customerAccount);
                }
            }

        }
    }

}
