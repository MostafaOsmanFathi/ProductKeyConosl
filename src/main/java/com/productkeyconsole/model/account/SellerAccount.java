package com.productkeyconsole.model.account;

import com.productkeyconsole.model.productkey.Key;
import com.productkeyconsole.model.productkey.ProductKey;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public final class SellerAccount extends Account {

    private final ArrayList<ProductKey> listOfProductKeys;
    static final PrintWriter printWriter;
    static final String file = SAVEINPATH + "SellerAccount.txt";

    static {
        try {
            printWriter = new PrintWriter(new FileWriter(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SellerAccount(String name, String email, String password, Address address) {
        super(name, email, password, address);
        listOfProductKeys = new ArrayList<>();
        SaveInFile();
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

    public String[] getListOfProductKeys() {
        String[] res = new String[listOfProductKeys.size()];
        for (int i = 0; i < listOfProductKeys.size(); i++) {
            res[i] = listOfProductKeys.get(i).getProductName() + " " + listOfProductKeys.get(i).getPrice();
        }
        return res;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + listOfProductKeys;
    }

    @Override
    public void loadFromFile() {

    }

    @Override
    public void SaveInFile() {
        printWriter.println(name + " " + email + " " + password + " " + balance + address);
        printWriter.flush();
    }
}