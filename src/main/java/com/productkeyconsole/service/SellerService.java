package com.productkeyconsole.service;

import com.productkeyconsole.model.productkey.ProductKey;
import com.productkeyconsole.model.productkey.Key;
import com.productkeyconsole.model.account.SellerAccount;
import org.jetbrains.annotations.NotNull;

public class SellerService {
    private final static SellerService instance = new SellerService();

    private SellerService() {
    }

    public static SellerService getCustomerService() {
        return instance;
    }

    public static boolean createAndAddProductKey(@NotNull SellerAccount sellerAccount, @NotNull String productName, @NotNull String description, int price) {
        if (!StoreIncomeService.takeAddingGameFee(sellerAccount)) {
            return false;
        }
        ProductKey productKey = new ProductKey(sellerAccount, sellerAccount.getEmail(), productName, description, price);
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
