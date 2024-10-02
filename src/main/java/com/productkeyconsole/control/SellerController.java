/*
 *  Copyright (c) 2024 Mostafa Osman
 *  All rights reserved.
 *
 *  This software and associated documentation files (the "Software") may not be
 *  used, copied, modified, merged, published, distributed, or sublicensed without
 *  explicit permission from the copyright owner.
 */
package com.productkeyconsole.control;

import com.productkeyconsole.model.account.SellerAccount;
import com.productkeyconsole.model.productkey.Key;
import com.productkeyconsole.model.productkey.ProductKey;
import com.productkeyconsole.service.SellerService;

import java.util.Scanner;

import static com.productkeyconsole.view.ConsoleViewer.makeHeader;
import static com.productkeyconsole.view.ConsoleViewer.makeHeaderWithRows;
import static com.productkeyconsole.control.AccountController.*;

/**
 * Handles seller-specific operations such as product key listings and account management.
 *
 * <p>This controller interacts with seller accounts and manages product key sales.
 *
 * @see SellerAccount
 * @see SellerService
 *
 * @version 1.0
 * @since 2024
 */
public class SellerController {
    private static final Scanner scanner = new Scanner(System.in);

    static void addProductController(SellerAccount sellerAccount) {
        System.out.println("Enter productkey Name: ");
        String productName = scanner.next();
        System.out.println("Enter productkey Description: ");
        String description = scanner.next();
        System.out.println("Enter productkey Price: ");
        double price = scanner.nextDouble();
        if (SellerService.createAndAddProductKey(sellerAccount, productName, description, price)) {
            makeHeader("product added successfully");
        } else {
            makeHeader("product adding filed");
        }
    }

    static void enterKeyMenu(SellerAccount sellerAccount, ProductKey productKey) {
        makeHeaderWithRows("Product Key Console\t\t\t" + productKey.getProductName() + "\t\t" + productKey.getDescription() + "\t\t" + productKey.getPrice(),
                "add New Key for curnt product:",
                "get Product Info");
        switch (scanner.nextInt()) {
            case 1:
                addKeyToProductKey(sellerAccount, productKey);
                break;
            case 2:
                makeHeader(productKey.getDescription());
                break;
        }

    }

    static void selectProductControllerSeller(SellerAccount sellerAccount) {
        productsSummeryController(sellerAccount);
        makeHeader("Select Product");
        System.out.println("enter product Name:");
        String productName = scanner.next();
        ProductKey tmp = sellerAccount.getProductKey(productName);
        if (tmp == null) {
            System.out.println("Product not found");
            return;
        }
        System.out.println("Do you want to add Key for this product? (Y/N)");
        String choice = scanner.next().toUpperCase();
        if (choice.equalsIgnoreCase("Y")) {
            enterKeyMenu(sellerAccount, tmp);
        }
    }

    static void productsSummeryController(SellerAccount sellerAccount) {
        makeHeaderWithRows("mostafa", sellerAccount.getListOfProductKeys());
    }

    static void addKeyToProductKey(SellerAccount sellerAccount, ProductKey productKey) {
        System.out.println("Enter productkey Key: ");
        String Key = scanner.next();
        SellerService.addKey(sellerAccount, productKey, new Key(Key));
    }

    static void sellerController(SellerAccount sellerAccount) {
        label:
        {
            while (logedInAccount != null) {
                makeHeaderWithRows("Seller Account Choices \t\t\t\t\t\t" + sellerAccount.getName(), "Deposit to your Account", "WithDraw to your Account", "Change Password", "Show Balance", "Account Information", "Remove My Account", "logout", "---", "Add Product to your Account:", "Select Product:", "Products Summery:");

                System.out.println("enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        depositController(sellerAccount);
                        break;
                    case 2:
                        withdrawController(sellerAccount);
                        break;
                    case 3:
                        changePasswordController(sellerAccount);
                        break;
                    case 4:
                        showBalanceController(sellerAccount);
                        break;
                    case 5:
                        ShowAccountInfoController(sellerAccount);
                        break;
                    case 6:
                        RemoveMyAccountController();
                        break;
                    case 7:
                        logout();
                        break label;
                    case 8:
                        addProductController(sellerAccount);
                        break;
                    case 9:
                        selectProductControllerSeller(sellerAccount);
                        break;
                    case 10:
                        productsSummeryController(sellerAccount);
                        break;
                    default:
                }
            }
        }
    }
}
