package com.productkeyconsole.view;

import de.vandermeer.asciitable.AsciiTable;

public class ConsoleViewer {
    private static final ConsoleViewer consoleViewer = new ConsoleViewer();

    private static final AsciiTable WelcomeScreen = new AsciiTable();

    private static final AsciiTable loginScreen = new AsciiTable();

    private static final AsciiTable createAccountScreen = new AsciiTable();


    private static final AsciiTable AccountChoices = new AsciiTable();

    private static final AsciiTable SellerAccountChoices = new AsciiTable();

    private static final AsciiTable CustomerAccountChoices = new AsciiTable();

    private static final AsciiTable AdminAccountChoices = new AsciiTable();


    static {
        int counter = 0;
        WelcomeScreen.addRule();
        WelcomeScreen.addRow("Welcome To Product Key Console");
        WelcomeScreen.addRule();
        WelcomeScreen.addRow("Choose an option from the list");
        WelcomeScreen.addRow(++counter + ".Login To Account (Admin | Seller | Customer):");
        WelcomeScreen.addRow(++counter + ".Create Account:");
        WelcomeScreen.addRule();

        createAccountScreen.addRule();
        createAccountScreen.addRow("Create Account");
        createAccountScreen.addRule();

        loginScreen.addRule();
        loginScreen.addRow("Login to your Account");

        counter = 0;

        AccountChoices.addRule();
        AccountChoices.addRow("Account Choices");
        AccountChoices.addRule();
        AccountChoices.addRow(++counter + "Deposit to your Account");
        AccountChoices.addRow(++counter + "WithDraw to your Account");
        AccountChoices.addRow(++counter + "WithDraw to your Account");
        AccountChoices.addRow(++counter + "Change Password");
        AccountChoices.addRow(++counter + "Show Balance");
        AccountChoices.addRow(++counter + "Account Information");
        AccountChoices.addRow(++counter + "Remove My Account");
        AccountChoices.addRule();


        SellerAccountChoices.addRule();
        SellerAccountChoices.addRow("Account Choices");
        SellerAccountChoices.addRule();
        SellerAccountChoices.addRow(++counter + "Deposit to your Account");
        SellerAccountChoices.addRow(++counter + "WithDraw to your Account");
        SellerAccountChoices.addRow(++counter + "WithDraw to your Account");
        SellerAccountChoices.addRow(++counter + "Change Password");
        SellerAccountChoices.addRow(++counter + "Show Balance");
        SellerAccountChoices.addRow(++counter + "Account Information");
        SellerAccountChoices.addRow(++counter + "Remove My Account");
        SellerAccountChoices.addRule();
        SellerAccountChoices.addRow(++counter + "Add Product to your Account:");
        SellerAccountChoices.addRow(++counter + "Select Product:");
        SellerAccountChoices.addRow(++counter + "Products Summery:");
        SellerAccountChoices.addRow(++counter + "Show selling information:");
        SellerAccountChoices.addRule();


        CustomerAccountChoices.addRule();
        CustomerAccountChoices.addRow("Account Choices");
        CustomerAccountChoices.addRule();
        CustomerAccountChoices.addRow(++counter + "Deposit to your Account");
        CustomerAccountChoices.addRow(++counter + "WithDraw to your Account");
        CustomerAccountChoices.addRow(++counter + "WithDraw to your Account");
        CustomerAccountChoices.addRow(++counter + "Change Password");
        CustomerAccountChoices.addRow(++counter + "Show Balance");
        CustomerAccountChoices.addRow(++counter + "Account Information");
        CustomerAccountChoices.addRow(++counter + "Remove My Account");
        CustomerAccountChoices.addRule();
        CustomerAccountChoices.addRow(++counter + "Show Products:");
        CustomerAccountChoices.addRow(++counter + "Select Product by Name:");
        CustomerAccountChoices.addRow(++counter + "Show My Products:");
        CustomerAccountChoices.addRule();


    }

    private ConsoleViewer() {
    }

    public static ConsoleViewer getInstance() {
        return consoleViewer;
    }

    public static void welcomeScreen() {
        System.out.println(WelcomeScreen.render());
    }

    public static void loginScreen() {
        System.out.println(loginScreen.render());
    }

    public static void CreateAccountScreen() {
        System.out.println(createAccountScreen.render());
    }

}
