package com.productkeyconsole.model.account;

import com.productkeyconsole.model.productkey.Key;
import com.productkeyconsole.model.productkey.ProductKey;

import java.util.ArrayList;

public final class SellerAccount extends Account {

    private final ArrayList<ProductKey> listOfProductKeys;

    public SellerAccount(String name, String email, String password, Address address) {
        super(name, email, password, address);
        listOfProductKeys = new ArrayList<>();
    }

    public ProductKey getProductKey(String productKeyName) {
        for (ProductKey productKey : listOfProductKeys) {
            if (productKey.getProductName().equals(productKeyName)) {
                return productKey;
            }
        }
        return null;
    }

    public boolean addProductKey(ProductKey productKey) {
        if (checkProductNameExist(productKey.getProductName()))
            return false;
        if (!listOfProductKeys.contains(productKey)) {
            listOfProductKeys.add(productKey);
            return true;
        }
        return false;
    }

    public ProductKey getProductKeyByName(String productName) {
        for (ProductKey productKey : listOfProductKeys) {
            if (productKey.getProductName().equals(productName)) {
                return productKey;
            }
        }
        return null;
    }

    public boolean checkProductNameExist(String productName) {
        for (ProductKey productKey : listOfProductKeys) {
            if (productKey.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public boolean addKeyForProduct(String productName, Key Key) {
        ProductKey productKey = getProductKeyByName(productName);
        if (productKey == null) return false;

        productKey.addKey(Key);
        return true;
    }

    public boolean removeProductKey(Object productName) {
        if (productName instanceof ProductKey tmp) {
            listOfProductKeys.remove(tmp);
            return true;
        } else if (productName instanceof String tmp) {
            listOfProductKeys.remove(tmp);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + listOfProductKeys;
    }
}