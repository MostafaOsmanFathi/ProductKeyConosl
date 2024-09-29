package com.productkeyconsole.service;

import com.productkeyconsole.model.account.CustomerAccount;
import com.productkeyconsole.model.productkey.Key;
import com.productkeyconsole.model.productkey.KeyInfoHolder;
import com.productkeyconsole.model.productkey.ProductKey;
import com.productkeyconsole.model.productkey.ProductKeyInfo;
import org.jetbrains.annotations.NotNull;

public class CustomerService {

    final static CustomerService customerService = new CustomerService();


    private CustomerService() {
    }

    public static CustomerService getCustomerService() {
        return customerService;
    }

    public static boolean buyProductKeyForCustomer(@NotNull CustomerAccount customerAccount, @NotNull ProductKey productKey) {
        if (productKey.hasKey() && customerAccount.withdraw(productKey.getPrice())) {
            Key key = productKey.getKey();
            productKey.sellLastKey();
            productKey.getSellerAccount().deposit(productKey.getPrice());
            ProductKeyInfo productKeyInfo = productKey.getProductKeyInfo();
            key.sellKeyToEmail(customerAccount);
            customerAccount.addKeyInfoHolder(new KeyInfoHolder(productKeyInfo, key));

            return true;
        }
        return false;
    }

    public static boolean buyProductKeyForCustomerByProductName(@NotNull CustomerAccount customerAccount, @NotNull String productName) {
        ProductKey tmp = ProductKey.getProductKeyByName(productName);
        if (tmp != null) {
            return buyProductKeyForCustomer(customerAccount, tmp);
        }
        return false;
    }

    public static boolean refundProductKeyForCustomer(@NotNull CustomerAccount customerAccount, @NotNull ProductKey productKey) {
        Key key = productKey.getKey();
        if (key.isExpired() && productKey.getSellerAccount().withdraw(productKey.getPrice())) {
            return false;
        }
        customerAccount.deposit(productKey.getPrice());

        key.setKeyStatusToAvailable();
        productKey.addKey(key);
        customerAccount.removeKeyAndGetIt(key);

        return true;
    }

}
