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
/**
 * Service responsible for managing store income generated from product key sales.
 *
 * <p>This class handles calculations and record-keeping for store income.
 *
 * @version 1.0
 * @since 2024
 */
public class StoreIncomeService {
    private final static StoreIncomeService storeIncomeService = new StoreIncomeService();
    static double storeIncome = 0.0;
    static double addingGameFees = 0.5f;
    static float transactionPercentage = 0.0f;

    private StoreIncomeService() {
    }

    public static float getTransactionPercentage() {
        return transactionPercentage;
    }

    public static void setTransactionPercentage(float transactionPercentage) {
        StoreIncomeService.transactionPercentage = transactionPercentage;
    }

    public StoreIncomeService getInstance() {
        return storeIncomeService;
    }

    public static boolean Deposit(double amount) {
        if (amount >= 0) {
            storeIncome += amount;
            return true;
        }
        return false;
    }

    public static boolean Withdraw(double amount) {
        if (amount <= storeIncome) {
            storeIncome -= amount;
            return true;
        }
        return false;
    }

    public static double calculateStorePercentage(double amount) {
        return amount * (transactionPercentage / 100);
    }
    public static boolean takeAddingGameFee(Account account) {
        return account.withdraw(addingGameFees);
    }
    public static double getTotalIncome() {
        return storeIncome;
    }
}
