/*
 *  Copyright (c) 2024 Mostafa Osman
 *  All rights reserved.
 *
 *  This software and associated documentation files (the "Software") may not be
 *  used, copied, modified, merged, published, distributed, or sublicensed without
 *  explicit permission from the copyright owner.
 */
package com.productkeyconsole.model.account;

import com.productkeyconsole.model.productkey.Key;
import com.productkeyconsole.model.productkey.KeyInfoHolder;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
/**
 * Represents a customer account in the system.
 *
 * <p>This class holds customer-specific data and provides methods for customer actions.
 *
 * @version 1.0
 * @since 2024
 */
public final class CustomerAccount extends Account {
    final ArrayList<KeyInfoHolder> listOfKeys;
    static final PrintWriter printWriter;
    static final String file = SAVEINPATH + "CustomerAccounts.txt";

    static {
        try {
            printWriter = new PrintWriter(new FileWriter(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CustomerAccount(String name, String email, String password, Address address) {
        super(name, email, password, address);
        listOfKeys = new ArrayList<>();
        SaveInFile();
    }

    public CustomerAccount(String name, String email, String password, double balance, Address address) {
        super(name, email, password, balance, address);
        listOfKeys = new ArrayList<>();
    }


    public void removeKeyAndGetIt(@NotNull Key key) {
        for (int i = 0; i < listOfKeys.size(); i++) {
            if (listOfKeys.get(i).key().getProductKey(this).equals(key.getProductKey(this))) {
                listOfKeys.remove(i);
                return;
            }
        }
    }

    public void addKeyInfoHolder(KeyInfoHolder key) {
        listOfKeys.add(key);
    }

    public boolean removeKeyInfoHolder() {
        if (listOfKeys.isEmpty()) {
            return false;
        }
        listOfKeys.removeLast();
        return true;
    }

    public static String[] getListOfKeysInfoForLib(CustomerAccount account) {
        String[] res = new String[account.listOfKeys.size()];
        for (int i = 0; i < account.listOfKeys.size(); i++) {
            res[i] = account.listOfKeys.get(i).keyInfo().productName() + " " + account.listOfKeys.get(i).key().getProductKey(account) + " " + account.listOfKeys.get(i).key().getSoldDate();
        }
        return res;
    }

    @Override
    public String toString() {
        if (listOfKeys.isEmpty()) {
            return "You don't have any keys";
        }
        StringBuilder sb = new StringBuilder();
        for (KeyInfoHolder key : listOfKeys) {
            Key tmpKey = key.key();
            sb.append(tmpKey.getProductKey(this)).append(" ").append(tmpKey.getCreationDate()).append(" <=> ").append(tmpKey.getExpiryDate()).append(" ").append(tmpKey.getSoldDate());
        }
        return sb.toString();
    }


    @Override
    public void SaveInFile() {
        printWriter.println(name + " " + email + " " + password + " " + balance + " " + address);
        printWriter.flush();
    }
}


