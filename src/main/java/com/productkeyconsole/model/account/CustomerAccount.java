package com.productkeyconsole.model.account;

import com.productkeyconsole.model.productkey.Key;
import com.productkeyconsole.model.productkey.KeyInfoHolder;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public final class CustomerAccount extends Account {
    final ArrayList<KeyInfoHolder> listOfKeys;

    CustomerAccount(String name, String email, String password, Address address) {
        super(name, email, password, address);
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
}


