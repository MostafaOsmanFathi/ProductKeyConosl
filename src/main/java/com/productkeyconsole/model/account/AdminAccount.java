package com.productkeyconsole.model.account;

import java.io.FileNotFoundException;

final public class AdminAccount extends Account {

    public AdminAccount(String name, String email, String password, Address address) {
        super(name, email, password, address);
    }


    @Override
    public void SaveInFile() throws FileNotFoundException {

    }
}
