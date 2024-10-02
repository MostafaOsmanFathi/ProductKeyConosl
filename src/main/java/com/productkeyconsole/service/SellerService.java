/*
 *  Copyright (c) 2024 Mostafa Osman
 *  All rights reserved.
 *
 *  This software and associated documentation files (the "Software") may not be
 *  used, copied, modified, merged, published, distributed, or sublicensed without
 *  explicit permission from the copyright owner.
 */
package com.productkeyconsole.service;

import com.productkeyconsole.model.productkey.ProductKey;
import com.productkeyconsole.model.productkey.Key;
import com.productkeyconsole.model.account.SellerAccount;
import org.jetbrains.annotations.NotNull;
/**
 * Service responsible for seller-related operations in the system.
 *
 * <p>This class manages seller accounts, product listings, and other seller-specific tasks.
 *
 * @see SellerAccount
 * @version 1.0
 * @since 2024
 */
public class SellerService {
    private final static SellerService instance = new SellerService();

    private SellerService() {
    }

    public static SellerService getCustomerService() {
        return instance;
    }

    public static boolean createAndAddProductKey(@NotNull SellerAccount sellerAccount, @NotNull String productName, @NotNull String description, double price) {
        if (!StoreIncomeService.takeAddingGameFee(sellerAccount)) {
            return false;
        }
        ProductKey productKey = new ProductKey(sellerAccount, productName, description, price);
        sellerAccount.addProductKey(productKey);
        return true;
    }

    public static boolean removeProductKey(@NotNull SellerAccount sellerAccount, @NotNull ProductKey productKey) {
        return sellerAccount.removeProductKey(productKey);
    }

    public static boolean removeProductKeyByName(@NotNull SellerAccount sellerAccount, @NotNull String productKeyName) {
        return sellerAccount.removeProductKey(productKeyName);
    }

    public static boolean addKey(@NotNull SellerAccount sellerAccount, @NotNull ProductKey productKey, Key key) {
        return productKey.addKey(key);
    }

    public static boolean addKeyByProductKeyName(@NotNull SellerAccount sellerAccount, @NotNull String productKeyName, @NotNull Key key) {
        ProductKey tmp = sellerAccount.getProductKeyByName(productKeyName);
        if (tmp == null) {
            return false;
        }
        addKey(sellerAccount, tmp, key);
        return true;
    }


}
