/*
 *  Copyright (c) 2024 Mostafa Osman
 *  All rights reserved.
 *
 *  This software and associated documentation files (the "Software") may not be
 *  used, copied, modified, merged, published, distributed, or sublicensed without
 *  explicit permission from the copyright owner.
 */
package com.productkeyconsole.model.account;

import java.io.FileNotFoundException;
/**
 * Represents an admin account in the system with elevated privileges.
 *
 * <p>Admin accounts can manage customer and seller accounts and have access to advanced system functions.
 *
 * @version 1.0
 * @since 2024
 */
final public class AdminAccount extends Account {

    public AdminAccount(String name, String email, String password, Address address) {
        super(name, email, password, address);
    }


    @Override
    public void SaveInFile() throws FileNotFoundException {

    }
}
