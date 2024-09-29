package com.productkeyconsole.model.productkey;

import com.productkeyconsole.model.account.Account;
import com.productkeyconsole.model.account.SellerAccount;

import java.util.ArrayList;
import java.util.Objects;

public class ProductKey {
    static ArrayList<ProductKey> productKeys = new ArrayList<>();

    private int soldCount;
    private final String productOwnerEmail;
    private final ArrayList<Key> listOfKeys;
    private final ProductKeyInfo productKeyInfo;
    private final SellerAccount sellerAccount;
    private double price;

    public ProductKeyInfo getProductKeyInfo() {
        return productKeyInfo;
    }

    public static ProductKey getProductKeyByName(String productName) {
        for (ProductKey productKey : productKeys) {
            if (productKey.getProductName().equals(productName)) {
                return productKey;
            }
        }
        return null;
    }

    public ProductKey(SellerAccount sellerAccount, String productName, String description, double price) {
        soldCount = 0;
        listOfKeys = new ArrayList<>();
        productKeyInfo = new ProductKeyInfo(productName, description);
        this.productOwnerEmail = sellerAccount.getEmail();
        this.sellerAccount = sellerAccount;
        this.price = price;

        productKeys.add(this);
    }

    public static ArrayList<String> getListOfKeysOfTheStore() {
        ArrayList<String> tmp = new ArrayList<>();
        for (ProductKey productKey : productKeys) {
            tmp.add(productKey.getProductKeyInfo().toString());
        }
        return tmp;
    }

    public double getPrice() {
        return price;
    }

    public Account getSellerAccount() {
        return sellerAccount;
    }

    public String getProductOwnerEmail() {
        return productOwnerEmail;
    }

    public String getProductName() {
        return productKeyInfo.productName();
    }

    public String getDescription() {
        return productKeyInfo.description();
    }

    public int getSoldCount() {
        return soldCount;
    }


    public void increaseSoldCount() {
        ++soldCount;
    }

    public boolean addKey(Key key) {
        if (key != null && !listOfKeys.contains(key)) {
            listOfKeys.add(key);
            return true;
        }
        return false;
    }

    public Key getKey() {
        if (!listOfKeys.isEmpty()) {
            return listOfKeys.getLast();
        }
        return null;
    }

    public void sellLastKey() {
        if (!listOfKeys.isEmpty()) {
            listOfKeys.removeLast();
            ++soldCount;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ProductKey tmp) {
            return productKeyInfo.productName().equals(tmp.productKeyInfo.productName());
        } else if (o instanceof String tmp) {
            return productKeyInfo.productName().equals(tmp);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productKeyInfo.productName(), productOwnerEmail);
    }

    @Override
    public String toString() {
        return productKeyInfo.productName() + " " + soldCount + " " + productOwnerEmail;
    }

    public boolean hasKey() {
        return !listOfKeys.isEmpty();
    }
}
