package com.productkeyconsole.control;

import com.productkeyconsole.model.account.SellerAccount;
import com.productkeyconsole.model.productkey.ProductKey;
import com.productkeyconsole.service.SellerService;

import java.util.Scanner;

import static com.productkeyconsole.view.ConsoleViewer.makeHeaderWithRows;
import static com.productkeyconsole.control.AccountController.*;


public class SellerController {
    private static final Scanner scanner = new Scanner(System.in);

    static void addProductController(SellerAccount sellerAccount) {
        ProductKey productKey;
        System.out.println("Enter productkey Name: ");
        String productName = scanner.next();
        System.out.println("Enter productkey Description: ");
        String description = scanner.next();
        System.out.println("Enter productkey Price: ");
        double price = scanner.nextDouble();
        SellerService.createAndAddProductKey(sellerAccount, productName, description, price);
    }

    static void enterKey(ProductKey productKey) {

    }

    static void selectProductControllerSeller(SellerAccount sellerAccount) {
        System.out.println("enter product Name:");
        String productName = scanner.next();
        ProductKey tmp = sellerAccount.getProductKey(productName);
        if (tmp == null) {
            System.out.println("Product not found");
            return;
        }
        System.out.println("Do you want to add Key for this product? (Y/N)");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("Y")) {
            enterKey(tmp);
        }
    }

    static void productsSummeryController() {

    }

    static void addKeyToProductKey() {

    }

    static void sellerController(SellerAccount sellerAccount) {
        label:
        {
            while (logedInAccount != null) {
                makeHeaderWithRows("Seller Account Choices \t\t\t\t\t\t" + sellerAccount.getName(), "Deposit to your Account", "WithDraw to your Account", "Change Password", "Show Balance", "Account Information", "Remove My Account", "logout", "---",
                        "Add Product to your Account:",
                        "Select Product:", "Products Summery:",
                        "Show selling information:",
                        "add Product Key:");

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
                        productsSummeryController();
                        break;
                    case 11:
                        addKeyToProductKey();
                        break;
                    default:
                }
            }
        }
    }
}
